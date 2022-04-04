package com.example.service.Impl;

import com.example.dao.BookDao;
import com.example.domain.book;
import com.example.service.BookService;
import com.example.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public Boolean save(book book) {
       return bookDao.addBook(book)>0;
    }

    @Override
    public Boolean update(book book) {
        String key =redisUtil.getKey(book.getId());

        if(bookDao.updateBook(book)>0) {
            if (redisUtil.hasKey(key)) {
                book oldBook = (book) redisUtil.get(key);
                oldBook.combine(book);
                redisUtil.set(key,oldBook);
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (bookDao.deleteBook(id)>0) {
            redisUtil.remove(redisUtil.getKey(id));
            return true;
        }
        return false;
    }

    @Override
    public book getById(int id) {
        book book;
        String key =redisUtil.getKey(id);

        if(redisUtil.hasKey(key)) {
            book = (book)redisUtil.get(key);
        }else{
            book = bookDao.getByID(id);
            if (book!=null) {
                if (!redisUtil.set(key, book)) System.out.println("redis插入失败");
            }
        }
        return book;
    }

    @Override
    public List<book> getALL() {
        return bookDao.getAll();
    }

    @Override
    public List<book> getConditionQuery(book book) {
        return bookDao.getConditionBook(book);
    }

    @Override
    public PageInfo<book> getPageBook(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List<book> all = bookDao.getAll();
        return new PageInfo<>(all);
    }

    @Override
    public PageInfo<book> PageGetCondition(int currentPage, int pageSize, book book) {
        PageHelper.startPage(currentPage, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List<book> all = bookDao.getConditionBook(book);
        System.out.println(all);
        return new PageInfo<>(all);
    }
}

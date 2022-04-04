package com.example;

import com.example.dao.BookDao;
import com.example.domain.book;
import com.example.service.Impl.BookServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot0103BookSsmApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void selectTest() {
       // List<book> all = bookDao.getAll();
        book byID = bookDao.getByID(1);
        System.out.println(byID);
    }

    @Test
    void selectConditionQueryTest() {
        book book = new book();
        book.setDes("ddd");
        book.setName("fx");
       List<book> all = bookDao.getConditionBook(book);
        System.out.println(all);
    }

    @Test
    void insertTest(){
        book book = new book();
        book.setName("eeee");
        book.setType("wexffg");
        book.setDes("wwweeqq");
        bookDao.addBook(book);
    }

    @Test
    void deleteBookTest(){
        bookDao.deleteBook(32);
    }

    @Test
    void updateTest(){
        book book = new book();
        book.setId(32);
        book.setDes("qqqqq");
        book bookDefault = new book(32,"aweddfdf","wqedg","wwwe");
        bookDao.updateBook(bookDefault);
    }


    //pagehelper分页插件测试
    @Test
    void pagehelperTest(){
        PageHelper.startPage(2, 5); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List<book> all = bookDao.getAll();
        PageInfo<book> pageInfo = new PageInfo<book>(all);
        System.out.println(all);
    }


    @Test
    void serviceTest(){
        book book = new book();
        book.setId(4);
        book.setDes("qqqq");
        bookService.update(book);
    }

}

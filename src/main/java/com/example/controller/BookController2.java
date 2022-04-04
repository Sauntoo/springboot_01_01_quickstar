package com.example.controller;


import com.example.controller.utilis.res;
import com.example.domain.book;
import com.example.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books"
)
public class BookController2 {

    @Autowired
    private BookService bookService;


    @GetMapping("{id}")
    public res getById(@PathVariable int id){
        return new res(true,bookService.getById(id));
    }

   // @GetMapping("{currentPage}/{pageSize}")
    public res getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return new res(true,bookService.getPageBook(currentPage,pageSize));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public res getConditionPage(@PathVariable int currentPage, @PathVariable int pageSize ,book book){
        System.out.println(book+"===============================================");
        return new res(true,bookService.PageGetCondition(currentPage,pageSize,book));
    }

    @GetMapping
    public res getByAll(){
        return new res(true,bookService.getALL());
    }

    @PostMapping
    public res save(@RequestBody book book){
        return new res(bookService.save(book));
    }

    @PutMapping
    public res alter(@RequestBody book book){
        return new res(bookService.update(book),book);
    }

    @DeleteMapping("{id}")
    public res delete(@PathVariable int id) throws Exception {
        //异常测试
//        if (id==1){
//            throw new Exception();
//        }
        return new res(bookService.delete(id));
    }

}

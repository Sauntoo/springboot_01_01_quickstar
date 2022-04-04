package com.example.controller;


import com.example.domain.book;
import com.example.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("{id}")
    public book getById(@PathVariable int id){
        book byId = bookService.getById(id);
        return byId;
    }

    @GetMapping("{currentPage}/{pageSize}")
    public PageInfo<book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return bookService.getPageBook(currentPage,pageSize);
    }

    @GetMapping
    public List<book> getByAll(){
        return bookService.getALL();
    }

    @PostMapping
    public Boolean save(@RequestBody book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean alter(@RequestBody book book){
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable int id){
        return bookService.delete(id);
    }

}

package com.example.service;

import com.example.domain.book;
import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface BookService {
    Boolean save(book book);
    Boolean update(book book);
    Boolean delete(int id);
    book getById(int id);
    List<book> getALL();
    List<book> getConditionQuery(book book);
    PageInfo<book> getPageBook(int currentPage, int pageSize);
    PageInfo<book> PageGetCondition(int currentPage, int pageSize,book book);
}

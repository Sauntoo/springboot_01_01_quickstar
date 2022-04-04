package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class book implements Serializable {
    private int id;
    private String type;
    private String name;
    private String des;

    public void combine(book book){
        if (book.getDes()!=null) this.des=book.getDes();
        if (book.getName()!=null) this.name=book.getName();
        if (book.getType()!=null) this.type=book.getType();
    }
}

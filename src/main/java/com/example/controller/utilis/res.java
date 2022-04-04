package com.example.controller.utilis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class res implements Serializable {
    private Boolean flag;
    private Object data;
    private String msg;

    public res (Boolean flag){
        this.flag=flag;
    }

    public res (Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public res (String msg){
        this.flag=false;
        this.msg=msg;
    }

}

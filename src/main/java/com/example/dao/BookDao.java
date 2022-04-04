package com.example.dao;

import com.example.domain.book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {


    @Select({"<script>",
            "select * from book",
            "<where>",
            "<trim suffixOverrides=\"and\">",
            "<if test=\"type!=null\">",
            "type like \"%\"#{type}\"%\" and",
            "</if>",
            "<if test=\"name!=null\">",
            "name  like \"%\"#{name}\"%\" and",
            "</if>",
            "<if test=\"des!=null\">",
            "des like \"%\"#{des}\"%\" and",
            "</if>",
            "</trim>",
            "</where>",
            "</script>"})
    List<book> getConditionBook(book book);


    @Select("select * from book")
    List<book> getAll();

    @Select("select * from book where id=#{id}")
    book getByID(int id);


    @Options(useGeneratedKeys = true,keyProperty = "id") //设置id自增
    @Insert("insert into book (type,name,des) value (#{type},#{name},#{des})")
    int addBook(book book);

    //动态sql配置
    @Update({"<script>",
            "update book",
            "<trim prefix=\"set\" suffixOverrides=\",\">",
            "<if test=\"type!=null\">",
             "type=#{type},",
            "</if>",
            "<if test=\"name!=null\">",
            "name=#{name},",
            "</if>",
            "<if test=\"des!=null\">",
            "des=#{des},",
            "</if>",
            "</trim>",
            "where id = #{id}",
            "</script>"
             })
    int updateBook(book book);


    @Delete("delete from book where id=#{id}")
    int deleteBook(int id);


}

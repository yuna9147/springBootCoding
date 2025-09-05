package com.example.mapper;

import com.example.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {


    @Results(id="bookResult",value={
            @Result(column = "book_no",property="bookNo"),
            @Result(column = "title",property="bookTitle"),
            @Result(column = "writer",property="bookWriter"),
            @Result(column = "price",property="bookPrice"),
    })

    @Select( "SELECT book_no, title, writer, price FROM book2 ORDER BY book_no")


    public  List<Book> selectAllList();
}

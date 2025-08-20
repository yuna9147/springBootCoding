package com.boot.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.boot.example.domain.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<Book> bookList();
    public int bookInsert(Book book);
    public int bookDelete(Book book);
    public int bookUpdate(Book book);

}

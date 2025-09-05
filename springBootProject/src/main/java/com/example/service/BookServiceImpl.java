package com.example.service;

import com.example.book.Book;
import com.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Override
    public List<Book> selectAllList() {

        return bookMapper.selectAllList();
    }
}

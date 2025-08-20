package com.boot.example.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private String publishDate;
    private int price;
}

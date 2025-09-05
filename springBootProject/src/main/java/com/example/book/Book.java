package com.example.book;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookNo;
    private String bookTitle;
    private String bookWriter;
    private int bookPrice;

}
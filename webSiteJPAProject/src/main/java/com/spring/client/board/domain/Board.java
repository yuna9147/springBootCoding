package com.spring.client.board.domain;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Board {
    private Long no;
    private String name;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private Integer hit = 0;
}

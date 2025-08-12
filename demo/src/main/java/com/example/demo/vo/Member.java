package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private String email;
    private int age;
}

package com.boot.example.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Course {
    private int no;
    private String courseNumber;
    private String courseName;
    private int courseCredit;
    private String courseSection;
}

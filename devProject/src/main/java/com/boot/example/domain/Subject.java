package com.boot.example.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Subject {
    private int no;
    private String subjectNumber;
    private String subjectName;
}

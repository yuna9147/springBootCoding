package com.boot.example.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private int no;
    private String studentNum;
    private String studentName;
    private String studentId;
    private String subjectNum;
    private String studentBirthday;
    private String studentPhone;
    private String studentAddress;
    private String studentEmail;
}

package com.boot.example.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SubjectMapperTests {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void SubjectListTest() {
        subjectMapper.subjectList().stream().forEach(subject -> log.info(subject.toString()));
    }
}

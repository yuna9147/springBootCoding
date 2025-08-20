package com.boot.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.boot.example.domain.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    public List<Student> studentList();

}

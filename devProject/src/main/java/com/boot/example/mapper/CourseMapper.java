package com.boot.example.mapper;

import com.boot.example.domain.Course;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface CourseMapper {
    @Results(id = "courseResult", value = {
        @Result(property = "no", column = "no"),
        @Result(property = "courseNumber", column ="c_num"),
        @Result(property = "courseName", column ="c_name"),
        @Result(property = "courseCredit", column ="c_credit"),
        @Result(property = "courseSection", column ="c_section")
    })
    @Select("""
                SELECT no, c_num, c_name, c_credit, c_section
                FROM course
            """)

    public List<Course> courseList();
}

package com.boot.example.controller;

import com.boot.example.domain.Course;
import com.boot.example.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/courseList")
    @ResponseBody
    public List<Course> courseList(){
        List<Course>  courseList = courseService.courseList();
        return courseList;
    }
}


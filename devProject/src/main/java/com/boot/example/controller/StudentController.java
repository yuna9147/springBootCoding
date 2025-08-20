package com.boot.example.controller;

import com.boot.example.domain.Student;
import com.boot.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/studentList")
    public String studentList(Model model, Student student){
        List<Student> studentList = studentService.studentList();
        model.addAttribute("studentList", studentList);
        model.addAttribute("student",student);
        return "/student/studentList";
    }
}

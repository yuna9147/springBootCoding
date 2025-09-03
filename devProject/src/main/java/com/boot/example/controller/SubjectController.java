package com.boot.example.controller;

import com.boot.example.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.example.domain.Subject;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService  subjectService;

    @GetMapping("subjectAllList")
    @ResponseBody
    public List<Subject> subjectList(){
        List<Subject> subjectAllList = subjectService.subjectList();
        return subjectAllList;
    }
}

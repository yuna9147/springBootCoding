package com.boot.example.controller;

import com.boot.example.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.example.domain.Subject;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller //이 클래스가 웹 요청을 처리하는 컨트롤러임을 명시
@RequestMapping("subject")
@RequiredArgsConstructor        //final 필드의 생성자를 자동 생성
public class SubjectController {
    private final SubjectService  subjectService;   //서비스계층을 주입받아 컨트롤러에서 사용하기 위해

    @GetMapping("subjectAllList")
    @ResponseBody       //JSON 데이터를 반환하기 위해 사용
    public List<Subject> subjectList(){ //과목 리스트를 가져오는 요청을 처리하는 핵심 메서드
        List<Subject> subjectAllList = subjectService.subjectList();    //실제 데이터 조회는 서비스 계층에 위임.
        return subjectAllList;  //가져온 데이터를 클라이언트에 반환.
    }
}

package com.boot.example.controller;

import com.boot.example.domain.ExampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping(value="/getText", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getText(){
        return "안녕하세요";
    }

    @GetMapping("/getExample")
    public ExampleVO getSample() {
        return new ExampleVO(1,"홍길동","010-1234-5678");
    }
    @GetMapping("/getList")
    public List<ExampleVO> getList() {
        List<ExampleVO> list = new ArrayList<>();
        list.add(new ExampleVO(1,"홍길동","010-6703-1120"));
        list.add(new ExampleVO(2,"한늘봄","010-3011-3420"));
        list.add(new ExampleVO(3,"이진희","010-5872-8041"));
        list.add(new ExampleVO(4,"박철희","010-5702-5782"));

        return list;
    }

    @GetMapping(value="/getMap",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ExampleVO> getMap() {
        Map<String, ExampleVO> map = new HashMap<>();
        map.put("First",new ExampleVO(5,"이진수","010-2359-6570"));

        return map;
    }
}

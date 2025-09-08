package com.spring.client.article.controller;

import com.spring.client.article.domain.Article;
import com.spring.client.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/articleList")
    public String articleList(Article article,Model model){
        List<Article> articleList = articleService.articleList(article);

        model.addAttribute("articleList",articleList);
        return "client/article/articleList";
    }

    @GetMapping("/insertForm")
    public String insertForm(Article article){
        return "client/article/insertForm";
    }

    @PostMapping("/articleInsert")
    public String articleInsert(Article article) {
        articleService.articleInsert(article);
        return "redirect:/article/articleList";
    }

}

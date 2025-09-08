package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.client.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    public final ArticleRepository articleRepository;

    @Override
    public List<Article> articleList(Article article){
        return articleRepository.findAll();
    }

    @Override
    public void articleInsert(Article article) {articleRepository.save(article);}
}

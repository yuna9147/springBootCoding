package com.spring.client.article.service;

import com.spring.client.article.domain.Article;


import java.util.List;

public interface ArticleService {
    public List<Article> articleList(Article article);
    public void articleInsert(Article article);
}

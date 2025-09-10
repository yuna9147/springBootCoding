package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.common.dto.PageRequestDTO;
import com.spring.common.dto.PageResponseDTO;


import java.util.List;

public interface ArticleService {
    public List<Article> articleList(Article article);
    public void articleInsert(Article article);
    public Article getArticle(Long no);
    public Article articleHitUpdate(Article article);
    public Article articleDetail(Article article);
    public void articleUpdate(Article article);
    public void articleDelete(Article article);

    public PageResponseDTO<Article> list(PageRequestDTO pageRequestDTO);
}

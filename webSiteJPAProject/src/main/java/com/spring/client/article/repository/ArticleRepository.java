package com.spring.client.article.repository;


import com.spring.client.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContaining(String title);
    List<Article> findByNameContaining(String name);
    List<Article> findByContentContaining(String content);

    List<Article> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Article> findByOrderByNoDesc();
}

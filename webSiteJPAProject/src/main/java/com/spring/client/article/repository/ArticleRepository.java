package com.spring.client.article.repository;


import com.spring.client.article.domain.Article;
import com.spring.client.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContaining(String title);
    List<Article> findByNameContaining(String name);
    List<Article> findByContentContaining(String content);

    List<Article> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Article> findByOrderByNoDesc();


    Page<Article> findAll(Pageable pageable);
    Page<Article> findByTitleContaining(String keyword, Pageable pageable);

    Page<Article> findByNameContaining(String name, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);

    Page<Article> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    @Query("SELECT a FROM Article a")
    public List<Article> articleList();

    //?다음에 위치 값을 지정하는 위치 기준 파라미터 사용
    @Query("SELECT a FROM Article a WHERE a.no = ?1")
    public Article articleDetail(Long no);

    @Query("SELECT a FROM Article a")
    public Page<Article> articleListPaging(Pageable pageable);

    @Query(value = "SELECT no, name, title, content, hit, reg_date FROM boot_article ORDER BY no DESC",nativeQuery = true)
    public List<Article> articleAllList();
}

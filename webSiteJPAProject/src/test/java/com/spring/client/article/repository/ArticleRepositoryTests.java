package com.spring.client.article.repository;

import com.spring.client.article.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class ArticleRepositoryTests {
    @Autowired
    private ArticleRepository articleRepository;

    //게시판 등록- save();
    @Test
    public void articleInsertTest(){
        Article article = new Article();
        article.setName("홍길동");
        article.setTitle("터키 애플티");
        article.setContent("차 정보: TEA BASE - 그린루이보스 차 /  RECIPE - 사과, 모과 / CAFFEINE - 미함유");
        article.setRegDate(LocalDateTime.now());

        log.info("alrticle 테이블에 첫번째 데이터 입력");
        articleRepository.save(article);

        Article article1 = new Article();
        article1.setName("메가커피");
        article1.setTitle("신메뉴 '누룽지 바삭 프라페'출시");
        article1.setContent("대왕님표 여주쌀로 만든 누릉지를 넣어 달달 꼬소~한 프라페 위로 바삭바삭한 누룽지를 한번 더 올린 가을시즌 한정 프라페");
        article1.setRegDate(LocalDateTime.now());

        log.info("alrticle 테이블에 두번째 데이터 입력");
        articleRepository.save(article1);

    }
}

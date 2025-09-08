package com.spring.client.comment.repository;

import com.spring.client.article.domain.Article;
import com.spring.client.comment.domain.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommentRepositoryTests {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void commentInsertTest() {
        Article article = new Article();
        article.setNo(1L);

        Comment comment = new Comment();
        comment.setNickname("아만다");
        comment.setBody("애플티 너무 맛있어요!!");
        comment.setArticle(article);
        log.info("comment 테이블에 첫번째 데이터 입력");
        commentRepository.save(comment);

        Comment comment1 = new Comment();
        comment1.setNickname("제인");
        comment1.setBody("사과랑 모과가 들어가서그런지 과일향이 진하고 좋아요!");
        comment1.setArticle(article);
        log.info("comment 테이블에 두번째 데이터 입력");
        commentRepository.save(comment1);

        Comment comment2 = new Comment();
        comment2.setNickname("폴");
        comment2.setBody("제 입맛에는 너무 달게 느껴졌어요..ㅠ");
        comment2.setArticle(article);
        log.info("comment 테이블에 세번째 데이터 입력");
        commentRepository.save(comment2);

    }
}

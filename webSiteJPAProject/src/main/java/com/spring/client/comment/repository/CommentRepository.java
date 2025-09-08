package com.spring.client.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.client.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.article.no = ?1")
    List<Comment> articleNoCommentList(Long no);
    List<Comment> findByNickname(String nickname);
}
package com.spring.client.comment.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.spring.client.article.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * -엔티티와 리파지터리의 개념
 * • 엔티티: DB 데이터를 담는 자바 객체로, 엔티티를 기반으로 테이블 생성
 * • 리파지터리: 엔티티를 관리하는 인터페이스로, 데이터 CRUD 등의 기능 제공
 */

@Setter
@Getter
//@ToString
@ToString(exclude="article")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boot_comment")
@SequenceGenerator(name = "comment_generator",
        sequenceName = "boot_comment_seq",
        initialValue = 1,
        allocationSize = 1)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String body;

    @CreationTimestamp
    @ColumnDefault(value = "sysdate")
    private LocalDateTime cdate;

    @ManyToOne(fetch= FetchType.LAZY) // Comment 엔티티와 Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="no", nullable=false)   // 외래키 생성, Article 엔티티의 기본키(no)와 매핑
    @JsonBackReference  //순환 참조 방지
    private Article article; // 해당 댓글의 부모 게시글
}
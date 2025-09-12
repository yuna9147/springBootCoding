package com.spring.client.article.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.client.comment.domain.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@ToString (exclude = "comments") //양방향 참조에서 상호 호출 방지
@Entity
@Table(name = "boot_article")
@SequenceGenerator(name="article_generator",sequenceName ="boot_article_seq", initialValue=1, allocationSize=1)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="article_generator")
    private Long no;

    @Column(length=15, nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable=false)
    private String content;

    @CreationTimestamp
    @ColumnDefault(value="sysdate")
    private LocalDateTime regDate;

    @ColumnDefault(value = "0")
    private Integer hit = 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article", fetch = FetchType.EAGER)
    @JsonManagedReference //양방향 순환 참조 방지
    private List<Comment> comments; //댓글 목록 저장 필드

}

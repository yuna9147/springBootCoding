package com.spring.client.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
//엔티티와 매핑할 테이블 지정, name 속성값으로 테이블명 설정
@Entity
@Table(name="boot_board")
@SequenceGenerator(
        name="boot_board_generator",
        sequenceName = "boot_board_seq",
        initialValue = 1,
        allocationSize = 1 )

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boot_board_generator")
    private Long no;    //null을 리턴할 수 있게 하려고 객체타입 사용함. long으로도 사용 가능하긴함.

    @Column(length = 15 , nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    //대용량 데이터 저장 자료형 Lob
    @Lob
    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @ColumnDefault(value="sysdate")
    private LocalDateTime regDate;

    @ColumnDefault (value= "0")
    private Integer hit = 0;

    @Transient
    private MultipartFile file;

    @Column
    private String filename = "";

    // @Column
// private String thumbname   =""; 	// 실제서버에 저장할 썸네일 이미지 파일명


}

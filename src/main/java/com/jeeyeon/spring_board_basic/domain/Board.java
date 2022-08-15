package com.jeeyeon.spring_board_basic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Board extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String password;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;


    public Board(BoardRequestDto boardRequestDTO){
        this.title = boardRequestDTO.getTitle();
        this.comment = boardRequestDTO.getComment();
        this.name = boardRequestDTO.getName();
        this.password = boardRequestDTO.getPassword();
    }


    public void update(BoardRequestDto course){
        this.title = course.getTitle();
        this.comment = course.getComment();
        this.name = course.getName();
        this.password = course.getPassword();
    }


}



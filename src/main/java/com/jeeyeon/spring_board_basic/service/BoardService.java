package com.jeeyeon.spring_board_basic.service;



import com.jeeyeon.spring_board_basic.domain.Board;
import com.jeeyeon.spring_board_basic.domain.BoardRepository;
import com.jeeyeon.spring_board_basic.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository boardRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }      -> RequiredArgsConstructor 때문에 생성 안해두 됨

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(boardRequestDto);
        return board.getId();
    }


    @Transactional
    public Board findByID(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return board;
    }

    @Transactional
    public String Is_correctpw(Long id, String pw){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (board.getPassword().equals(pw)){
            return "비밀번호가 일치합니다";
        }

        return "비밀번호가 일치하지 않습니다.";
    }

}

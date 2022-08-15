package com.jeeyeon.spring_board_basic.controller;


import com.jeeyeon.spring_board_basic.domain.Board;
import com.jeeyeon.spring_board_basic.domain.BoardRepository;
import com.jeeyeon.spring_board_basic.domain.BoardRequestDto;
import com.jeeyeon.spring_board_basic.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;

    private final BoardService boardService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Board course = new Board(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return boardRepository.save(course);
    }

    @GetMapping("/boards")
    public List<Object> getBoard() {
        return boardRepository.getMainBoard();
    }

    @GetMapping("/boards/{id}")
    public Board getDetailBoard(@PathVariable Long id) {
        return boardService.findByID(id);
    }

    @GetMapping("/boards/{id}/{password}")
    public String is_password(@PathVariable Long id, @PathVariable String password) {
        return boardService.Is_correctpw(id,password);
    }

    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }


    @DeleteMapping("/boards/{id}")
    public void deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardRepository.deleteById(id);
    }
}
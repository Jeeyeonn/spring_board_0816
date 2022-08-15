package com.jeeyeon.spring_board_basic.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "select title, name, modified_At from board", nativeQuery = true)
    List<Object> getMainBoard();

}
package com.jeeyeon.spring_board_basic.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {

    private final String title;
    private final String name;

    @Transient
    private final String password;
    private final String comment;
}

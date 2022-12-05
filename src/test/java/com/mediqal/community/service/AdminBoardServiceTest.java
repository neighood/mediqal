package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminBoardServiceTest {
    @Qualifier("admin")
    @Autowired
    private BoardService boardService;

//    수정
    @Test
    public void modifyTest(){
        BoardDTO boardDTO = boardService.show(7L);
        boardDTO.setBoardTitle("이거 어떡하지");
        boardDTO.setBoardContent("어떻게 아프냐면요");
        boardService.modify(boardDTO);
    }

//    삭제
    @Test
    public void removeTest(){
        boardService.remove(7L);
    }

//    조회
    @Test
    public void showTest(){
        log.info("유저 정보 : " + boardService.show(14L));
    }

//    전체 조회
    @Test
    public void showAllTest(){

    }
}
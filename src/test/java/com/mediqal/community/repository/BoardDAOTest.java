package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BoardDAOTest {

    @Autowired
    private  BoardDAO boardDAO;

//    수정
    @Test
    public void setTest(){
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.create(41L, "너무 아픈데", "감기 몸살로 아무것도 못하겠어요");
    }

//    삭제
    @Test
    public void removeTest(){
        boardDAO.remove(6L);
    }

//    조회
    @Test
    public void findByIdTest(){
        log.info("findByIdTest" + boardDAO.findById(7L));
    }

//    전제 조회
    @Test
    public void findAllTest(){

    }
}
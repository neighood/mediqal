package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
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
        boardDAO.adminRemove(6L);
    }

//    조회
    @Test
    public void findByIdTest(){
        log.info("findByIdTest" + boardDAO.adminFindById(7L));
    }

//    전제 조회
    @Test
    public void findAllTest(){

    }

    @Test
    void findAll() {
        boardDAO.findAll(new Criteria().create(1, 10)).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
}
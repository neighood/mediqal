package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void updateTest(){
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.create(6L,"내가 아파요", "감기 몸살이예요");
//        boardMapper.update(boardDTO);
    }

    @Test
    public void deleteTest(){
        boardMapper.delete(8L);
    }

    @Test
    public void selectTest(){
        log.info("boardSelect" + boardMapper.select(14L));
    }

    @Test
    public void selectAllTest(Criteria criteria){
        boardMapper.selectAll(criteria).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
}
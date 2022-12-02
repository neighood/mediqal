package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    //    추가

    //    수정
    public void set(BoardDTO boardDTO){
        boardMapper.update(boardDTO);
    }

    //    삭제
    public void remove(Long boardNumber){
        boardMapper.delete(boardNumber);
    }

    //    조회
    public BoardVO findById(Long boardNumber){
        return boardMapper.select(boardNumber);
    }

    //    전체 조회
    public List<BoardDTO> findAll(Criteria criteria) {
        return boardMapper.selectAll(criteria);
    }

    // 개수
    public int findCountAll(){
        return boardMapper.getTotal();
    }
}

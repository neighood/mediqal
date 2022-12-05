package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.domain.vo.BoardVO;
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

    //    조회
    public BoardDTO findByIdTest(Long boardNumber){
        return boardMapper.selectTest(boardNumber);
    }

    //    전체 조회
    public List<BoardDTO> findAll(BoardDTO boardDTO) {
        return boardMapper.selectAll(boardDTO);
    }

    // 개수
    public int findCountAll(BoardDTO boardDTO){
        return boardMapper.getTotal(boardDTO);
    }
    //    프로필 전체 조회
    public List<BoardDTO> profileSelectAll(BoardDTO boardDTO){
        return boardMapper.profileSelectAll(boardDTO);
    }
    //    프로필 전체 개수
    public int profileGetTotal(BoardDTO boardDTO){
        return boardMapper.profileGetTotal(boardDTO);
    }
    //    프로필 보드 삭제
    public void delete(Long boardNumber){
        boardMapper.delete(boardNumber);
    }
    //    좋아요 전체 갯수
    public int profileGetLikeTotal(BoardDTO boardDTO){
        return boardMapper.profileGetLikeTotal(boardDTO);
    }

}

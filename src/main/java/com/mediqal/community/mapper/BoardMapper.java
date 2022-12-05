package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //    추가

    //    수정
    public void update(BoardDTO boardDTO);

    //    삭제
    public void delete(Long boardNumber);

    //    조회
    public BoardVO select(Long boardNumber);

    //    조회
    public BoardDTO selectTest(Long boardNumber);

    //    전체 조회
    public List<BoardDTO> selectAll(BoardDTO boardDTO);

    //    전체 개수
    public int getTotal(BoardDTO boardDTO);
}

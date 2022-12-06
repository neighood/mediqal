package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //    추가

    //    수정
    public void update(BoardDTO boardDTO);
    public void updateBoardDTO(BoardDTO boardDTO);

    //    삭제
    public void delete(Long boardNumber);

    //    조회
    public BoardVO adminSelect(Long boardNumber);

    //    조회
    public BoardDTO adminSelectTest(Long boardNumber);

    //    전체 조회
    public List<BoardDTO> adminSelectAll(BoardDTO boardDTO);

    //    전체 개수
    public int adminGetTotal(BoardDTO boardDTO);


    //    프로필 조회
    public BoardVO profileSelect(Long boardNumber);
    //    프로필 전체 조회
    public List<BoardDTO> profileSelectAll(BoardDTO boardDTO);
    //    프로필 전체 갯수
    public int profileGetTotal(BoardDTO boardDTO);
    //    좋아요 전체 갯수
    public int profileGetLikeTotal(BoardDTO boardDTO);

    public List<BoardDTO> selectAll(Criteria criteria);
    public List<BoardDTO> selectBoardAll(Criteria criteria);

    public void insert(BoardDTO boardDTO);

    public int getTotal();

    public BoardDTO select(Long boardNumber);

    public int getCategoryTotal(String boardCategory);
}

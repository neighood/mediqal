package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.vo.CertifyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //    프로필 전체 조회
    public List<BoardDTO> profileSelectAll(BoardDTO boardDTO);
    //    프로필 전체 갯수
    public int profileGetTotal(BoardDTO boardDTO);
    //    프로필 보드 삭제
    public void delete(Long boardNumber);
    //    좋아요 전체 갯수
    public int profileGetLikeTotal(BoardDTO boardDTO);
}

package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {

    //    프로필 전체 조회
    public List<BoardDTO> profileSelectAll(BoardDTO boardDTO);
    //    프로필 전체 개수
    public int profileGetTotal(BoardDTO boardDTO);
    //    프로필 좋아요 삭제
    public void profileDelete(Long likeNumber);

//    보드 좋아요 총 값
    public int getTotal(BoardDTO boardDTO);
//    보드 좋아요 검사
    public int check(BoardDTO boardDTO);
//    보드 좋아요 추가
    public void insert(BoardDTO boardDTO);
//    보드 좋아요 삭제
    public void delete(BoardDTO boardDTO);
}

package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

    //    프로필 전체 조회
    public List<BoardDTO> profileSelectAll(BoardDTO boardDTO){
        return likeMapper.profileSelectAll(boardDTO);
    }
    //    프로필 전체 개수
    public int profileGetTotal(BoardDTO boardDTO){
        return likeMapper.profileGetTotal(boardDTO);
    }
    //    프로필 좋아요 삭제
    public void profileDelete(Long likeNumber){
        likeMapper.profileDelete(likeNumber);
    }
    //    보드 좋아요 총 값
    public int getTotal(BoardDTO boardDTO){
        return likeMapper.getTotal(boardDTO);
    }
    //    보드 좋아요 검사
    public int check(BoardDTO boardDTO){
        return likeMapper.check(boardDTO);
    }
    //    보드 좋아요 추가
    public void insert(BoardDTO boardDTO){
        likeMapper.insert(boardDTO);
    }
    //    보드 좋아요 삭제
    public void delete(BoardDTO boardDTO){
        likeMapper.delete(boardDTO);
    }
}

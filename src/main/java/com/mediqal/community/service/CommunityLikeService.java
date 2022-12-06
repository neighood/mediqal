package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.repository.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("community") @Primary
public class CommunityLikeService{

    private final LikeDAO likeDAO;

    //    보드 좋아요 총 값
    public int getTotal(BoardDTO boardDTO){
        return likeDAO.getTotal(boardDTO);
    }
    //    보드 좋아요 검사
    public int check(BoardDTO boardDTO){
        return likeDAO.check(boardDTO);
    }
    //    보드 좋아요 추가
    public void insert(BoardDTO boardDTO){
        likeDAO.insert(boardDTO);
    }
    //    보드 좋아요 삭제
    public void delete(BoardDTO boardDTO){
        likeDAO.delete(boardDTO);
    }
}

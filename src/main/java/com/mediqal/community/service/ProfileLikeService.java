package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.repository.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("like")
public class ProfileLikeService{

    private final LikeDAO likeDAO;

    public void remove(Long likeNumber) {
        likeDAO.profileDelete(likeNumber);
    }

    public List<BoardDTO> showAll(BoardDTO boardDTO) {
        return likeDAO.profileSelectAll(boardDTO);
    }

    public int getTotal(BoardDTO boardDTO) {
        return likeDAO.profileGetTotal(boardDTO);
    }


}

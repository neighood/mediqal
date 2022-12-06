package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("profile")
public class ProfileBoardService implements BoardService{

    private final BoardDAO boardDAO;

    @Override
    public void register(BoardDTO boardDTO) {

    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

    @Override
    public void remove(Long boardNumber) {
        boardDAO.delete(boardNumber);
    }

    @Override
    public BoardDTO show(Long boardNumber) {
        return null;
    }

    @Override
    public List<BoardDTO> showAll(Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }


    public BoardVO ajaxSelect(Long boardNumber) {
        return boardDAO.profileSelect(boardNumber);
    }

    public List<BoardDTO> showAll(BoardDTO boardDTO) {
        return boardDAO.profileSelectAll(boardDTO);
    }

    public int getTotal(BoardDTO boardDTO) {
        return boardDAO.profileGetTotal(boardDTO);
    }

    //    좋아요 전체 갯수
    public int profileGetLikeTotal(BoardDTO boardDTO){
        return boardDAO.profileGetLikeTotal(boardDTO);
    }


}

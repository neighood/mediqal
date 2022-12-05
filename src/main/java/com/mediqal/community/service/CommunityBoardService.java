package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("community") @Primary
public class CommunityBoardService implements BoardService{

    private final BoardDAO boardDAO;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(BoardDTO boardDTO) {
        boardDAO.save(boardDTO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

    @Override
    public void remove(Long boardNumber) {

    }

    @Override
    public BoardDTO show(Long boardNumber) {
        return null;
    }

    @Override
    public List<BoardDTO> showAll(Criteria criteria) {
        return boardDAO.findAll(criteria);
    }

    @Override
    public int getTotal() {
        return boardDAO.findCountAll();
    }

}

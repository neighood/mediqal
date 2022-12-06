package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
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
        boardDAO.setBoardDTO(boardDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long boardNumber) {
        boardDAO.remove(boardNumber);
    }

    @Override
    public BoardDTO show(Long boardNumber) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.create(boardDAO.findById(boardNumber));
//        boardDTO.setFiles(fileDAO.findAll(boardNumber));
        return boardDTO;
    }

    @Override
    public List<BoardDTO> showAll(Criteria criteria) {
        return boardDAO.findAll(criteria);
    }

    public List<BoardDTO> boardShowAll(Criteria criteria) {
        return boardDAO.boardFindAll(criteria);
    }

    @Override
    public int getTotal() {
        return boardDAO.findCountAll();
    }

    public int getCategoryTotal(String boardCategory) {
        return boardDAO.findByBoardCategoryCountAll(boardCategory);
    }

}

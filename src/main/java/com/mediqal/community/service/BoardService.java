package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.dto.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    //    추가
    public void register(BoardDTO boardDTO);
    //    수정
    public void modify(BoardDTO boardDTO);
    //    삭제
    public void remove(Long boardNumber);
    //    조회
    public BoardDTO show(Long boardNumber);
    //    전체 조회
    public List<BoardDTO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();
}

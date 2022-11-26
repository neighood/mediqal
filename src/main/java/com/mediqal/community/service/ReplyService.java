package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    //    추가
    public void register(ReplyDTO replyDTO);
    //    수정
    public void modify(ReplyDTO replyDTO);
    //    삭제
    public void remove(Long replyNumber);
    //    조회
    public ReplyDTO show(Long replyNumber);
    //    전체 조회
    public List<ReplyVO> showAll(Long boardNumber , Criteria criteria);
    //    전체 개수
    public int getTotal();

}

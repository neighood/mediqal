package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("mypage")
public class MypageReplyService implements ReplyService{

    @Override
    public void register(ReplyDTO replyDTO) {

    }

    @Override
    public void modify(ReplyDTO replyDTO) {

    }

    @Override
    public void remove(Long replyNumber) {

    }

    @Override
    public ReplyDTO show(Long replyNumber) {
        return null;
    }

    @Override
    public List<ReplyVO> showAll(Long boardNumber, Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }
}

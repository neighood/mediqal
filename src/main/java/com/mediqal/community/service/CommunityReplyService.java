package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.vo.ReplyVO;
import com.mediqal.community.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("community") @Primary
public class CommunityReplyService implements ReplyService{

    private final ReplyDAO replyDAO;

    @Override
    public void register(ReplyDTO replyDTO) {
        replyDAO.save(replyDTO);
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

    public List<ReplyDTO> replyShowAll(Long boardNumber) {
        return replyDAO.findAll(boardNumber);
    }

}

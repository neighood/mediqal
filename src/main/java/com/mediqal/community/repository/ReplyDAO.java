package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public List<ReplyDTO> findAll(Long boardNumber){
        return replyMapper.selectAll(boardNumber);
    }

    public void save(ReplyDTO replyDTO){
        replyMapper.insert(replyDTO);
    }

    public int showCount(Long boardNumber) {
        return replyMapper.countALL(boardNumber);
    }
}

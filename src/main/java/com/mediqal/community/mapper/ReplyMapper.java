package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public List<ReplyDTO> selectAll(Long boardNumber);

    public void insert(ReplyDTO replyDTO);
}

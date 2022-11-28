package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.ConfirmDTO;
import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.ConfirmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConfirmDAO {
    private final ConfirmMapper confirmMapper;

//    등업 신청
    public void insert(ConfirmDTO confirmDTO){
        confirmMapper.insert(confirmDTO);
    }
}

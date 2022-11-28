package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.ConfirmDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfirmMapper {
    //    등업 신청
    public void insert(ConfirmDTO confirmDTO);
}

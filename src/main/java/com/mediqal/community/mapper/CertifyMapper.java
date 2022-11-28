package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.CertifyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertifyMapper {
    //    파일 추가
    public void insert(CertifyVO certifyVO);
}

package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.CertifyVO;
import com.mediqal.community.mapper.CertifyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CertifyDAO {
    private final CertifyMapper certifyMapper;

    //    파일 추가
    public void insert(CertifyVO certifyVO){
        certifyMapper.insert(certifyVO);
    }
    
}

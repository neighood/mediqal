package com.mediqal.community.repository;

import com.mediqal.community.mapper.CertifyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CertifyDAO {
    private final CertifyMapper certifyMapper;
    
}

package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.CertifyVO;
import com.mediqal.community.mapper.CertifyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CertifyDAO {
    private final CertifyMapper certifyMapper;

    //    파일 추가
    public void insert(CertifyVO certifyVO){
        certifyMapper.insert(certifyVO);
    }
    //    파일 삭제
    public void remove(Long confirmNumber){
        certifyMapper.delete(confirmNumber);
    }
    //    파일 조회
    public List<CertifyVO> findAll(Long confirmNumber){
        return certifyMapper.selectAll(confirmNumber);
    }
    //    지난 날 파일 조회
    public List<CertifyVO> findOldFiles(){
        return certifyMapper.selectOldFiles();
    }
}

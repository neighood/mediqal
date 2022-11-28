package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.CertifyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertifyMapper {
    //    파일 추가
    public void insert(CertifyVO certifyVO);
    //    파일 삭제
    public void delete(Long confirmNumber);
    //    파일 조회
    public List<CertifyVO> selectAll(Long confirmNumber);
    //    지난 날 파일 조회
    public List<CertifyVO> selectOldFiles();
}

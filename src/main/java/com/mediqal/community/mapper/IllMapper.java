package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.IllVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllMapper {
    //    프로필 조회
    public List<IllVO> profileSelectAll(Long userNumber);
//    프로필 수정
    public void profileUpdate(IllVO illVO);
}

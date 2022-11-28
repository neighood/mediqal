package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.IllVO;
import com.mediqal.community.domain.vo.InterestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestMapper {
    //    프로필 조회
    public List<InterestVO> profileSelectAll(Long userNumber);
    //    프로필 수정
    public void profileUpdate(InterestVO interestVO);
}

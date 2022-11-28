package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.InterestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterestDAO {
    private final InterestMapper interestMapper;

//    프로필 조회
    public List<InterestVO> profileSelectAll(Long userNumber){
        return interestMapper.profileSelectAll(userNumber);
    }
    //    프로필 수정
    public void profileUpdate(InterestVO interestVO){ interestMapper.profileUpdate(interestVO);}
}

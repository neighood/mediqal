package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.IllVO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.IllMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IllDAO {
    private final IllMapper illMapper;

    //    프로필 조회
    public List<IllVO> profileSelectAll(Long userNumber){
        return illMapper.profileSelectAll(userNumber);
    }
    //    프로필 수정
    public void profileUpdate(IllVO illVO){ illMapper.profileUpdate(illVO);}
}

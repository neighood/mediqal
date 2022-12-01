package com.mediqal.community.mapper;


import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InterestMapperTest {

    @Autowired
    private InterestMapper interestMapper;

    @Test
    public void ProfileSelectAllTest(){
        interestMapper.profileSelectAll((long) 1).stream().map(InterestVO::getInterestName).forEach(log::info);
    }

    @Test
    public void profileUpdate(){
        InterestVO interestVO = new InterestVO();
        interestVO.setInterestNumber((long) 1);
        interestVO.setInterestName("안아파");
        interestMapper.profileUpdate(interestVO);
    }

    @Test
    public void insertInterestTest(){
        InterestVO interestVO = new InterestVO();
        interestVO.create(1L);
        interestMapper.insertInterest(interestVO);
    }


}
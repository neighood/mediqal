package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.InterestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InterestDAOTest {

    @Autowired
    private  InterestDAO interestDAO;

    @Test
    public void profileSelectAll(){
        interestDAO.profileSelectAll((long) 1).stream().map(InterestVO::getInterestName).forEach(log::info);
    }

    @Test
    public void profileUpdate(){
        InterestVO interestVO = new InterestVO();
        interestVO.setInterestNumber((long) 2);
        interestVO.setInterestName("안아파");
        interestDAO.profileUpdate(interestVO);
    }

    @Test
    public void saveTest(){
        InterestVO interestVO = new InterestVO();
        interestVO.create(3L,"당뇨");
        interestDAO.save(interestVO);
    }
}

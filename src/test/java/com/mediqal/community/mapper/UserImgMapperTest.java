package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.UserImgVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserImgMapperTest {

    @Autowired
    private UserImgMapper userImgMapper;


    @Test
    public void insertUserImgTest(){
        UserImgVO userImgVO = new UserImgVO();
        userImgVO.create(1L, true);
        userImgMapper.insertUserImg(userImgVO);
    }
}
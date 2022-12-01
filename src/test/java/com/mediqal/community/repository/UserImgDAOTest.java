package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.UserImgVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserImgDAOTest {

    @Autowired
    private UserImgDAO userImgDAO;

    //    추가
    @Test
    public void saveTest() {
        UserImgVO userImgVO = new UserImgVO();
//        userImgVO.create(4L, false);
        userImgVO.setUserNumber(5L);
        userImgDAO.save(userImgVO);
    }

}
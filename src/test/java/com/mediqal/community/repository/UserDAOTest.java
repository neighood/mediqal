package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserDAOTest {

    @Autowired
    private  UserDAO userDAO;

    //    삭제
//    @Test
//    public void removeTest(Long userNumber){
//        userDAO.remove(userNumber);
//    }

    //    조회
    @Test
    public void findByIdTest(){
        log.info("findByIdTest : " + userDAO.findById(2L));
    }

    //    전체 조회
//    @Test
//    public void findAllTest(){
//        userDAO.findAll().stream().map(UserVO::getUserNumber).forEach(log::info);
//    }
}
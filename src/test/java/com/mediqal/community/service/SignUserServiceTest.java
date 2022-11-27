package com.mediqal.community.service;

import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SignUserServiceTest {
    @Autowired
    private SignUserService signUserService;

    @Test
    public void saveTest(){
        UserVO userVO = new UserVO();
        userVO.create(0L,
                "jbg@naver.com",
                "1234",
                "장보고",
                "장장보고",
                "email",
                "일반",
                "",
                "",
                "",
                "");
        signUserService.signUp(userVO);
    }

    @Test
    public void findPasswordByEmailTest(){
        log.info("userPassword" + signUserService.findPassword("hgd@naver.com"));
    }

    @Test
    public void checkIdTest(){
        log.info("아이디 중복개수" + signUserService.checkId("ksy1@naver.com"));
    }

    @Test
    public void checkNickname(){
        log.info("닉네임 중복 개수" + signUserService.checkNickname("장장보고"));
    }



}
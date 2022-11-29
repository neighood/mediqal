package com.mediqal.community.service;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.IllVO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SignUserServiceTest {
    @Autowired
    private SignUserService signUserService;

    @Test
    public void saveTest(){
        UserDTO userDTO = new UserDTO();
        userDTO.create(
                "hds@naver.com",
                "5678",
                "한동석",
                "한한동석",
                "email",
                "일반",
                "",
                "",
                "",
                "");
        userDTO.getUserImgVO().create(10L, "userImg11", "C:\\upload", UUID.randomUUID().toString(), true, 300L);
        IllVO illVO = new IllVO();
        illVO.create(11L, "두통");
        InterestVO interestVO = new InterestVO();
        interestVO.create(11L, "두통");
        signUserService.signUp(userDTO);
//        UserImgVO userImgVO = new UserImgVO();
//        userImgVO.create(10L, "userImg11", "C:\\upload", UUID.randomUUID().toString(), true, 300L);
//        IllVO illVO = new IllVO();
//        illVO.create(11L, "두통");
//        InterestVO interestVO = new InterestVO();
//        interestVO.create(11L, "두통");
//        signUserService.signUp(userDTO, userImgVO, illVO, interestVO);
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
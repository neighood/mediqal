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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        UserImgVO userImgVO = new UserImgVO();
        IllVO ill1 = new IllVO();
        IllVO ill2 = new IllVO();
        InterestVO interest1 = new InterestVO();
        InterestVO interest2 = new InterestVO();

        ill1.create(0L);
        ill2.create(0L);
        interest1.create(0L);
        interest2.create(0L);

        List<IllVO> ills = new ArrayList<>(Arrays.asList(ill1, ill2));
        List<InterestVO> interests = new ArrayList<>(Arrays.asList(interest1, interest2));

//        userDTO.create(
//                "hgd16@naver.com",
//                "16",
//                "홍길동",
//                "홍홍길동",
//                "email",
//                "일반",
//                "",
//                "",
//                "",
//                "");

        userDTO.create( "wooparoo7014@naver.com",
                "7014",
                "김세윤",
                "홍홍길동",
                "email",
                "일반",
                "",
                "",
                "",
                "",
                ills,
                interests);
        userDTO.setIllVOs(ills);
        userDTO.setInterestVOs(interests);
        userImgVO.create(16L, true);
        userDTO.setUserImgVO(userImgVO);
        signUserService.signUp(userDTO);
//        userDTO.getUserImgVO().create(15L, "userImg11", "C:\\upload", UUID.randomUUID().toString(), true, 300L);
//        IllVO illVO = new IllVO();
//        illVO.create(0L, "치통");
//        InterestVO interestVO = new InterestVO();
//        interestVO.create(0L, "치통");
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
        log.info("userPassword" + signUserService.findPassword("abcd@naver.com"));
    }

    @Test
    public void checkIdTest(){
        log.info("아이디 중복개수" + signUserService.checkId("ksy1@naver.com"));
    }

    @Test
    public void checkNickname(){
        log.info("닉네임 중복 개수" + signUserService.checkNickname("장장보고"));
    }

    @Test
    public void loginTest(){log.info("로그인" + signUserService.login("abcd@naver.com", "5678"));}

}
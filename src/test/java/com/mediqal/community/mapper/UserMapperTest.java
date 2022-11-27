package com.mediqal.community.mapper;


import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest() {
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
                "1");
        userMapper.insert(userVO);
    }

    @Test
    public void findPasswordTest() {
        log.info("userPassword" + userMapper.findPassword("jbg@naver.com"));
    }

    @Test
    public void checkIdTest() {
        log.info("아이디 중복개수" + userMapper.checkId("ksy1@naver.com"));
    }

    @Test
    public void checkNickname() {
        log.info("닉네임 중복 개수" + userMapper.checkNickname("장장보고"));
    }


    @Test
    public void loginTest() {
        log.info("userNumber" + userMapper.login("ksy@naver.com", "1234"));

    }
}
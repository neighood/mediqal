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
    public void updateTest(){
        UserVO userVO = userMapper.select(2L);
        userVO.setUserPassword("1234");
        userVO.setUserNickname("수정된 닉네임");
        userMapper.update(userVO);
    }

    @Test
    public void deleteTest(){
        userMapper.delete(4L);
    }

    @Test
    public void selectTest(){
        log.info("select : " + userMapper.select(2L));
    }

    @Test
    public void selectAllTest(){
        userMapper.selectAll().stream().map(UserVO::getUserName).forEach(log::info);
    }
}
package com.mediqal.community.service;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminUserServiceTest {

    @Qualifier("admin")
    @Autowired
    private UserService userService;

    //      수정
    @Test
    public void modifyTest(){
        UserDTO userDTO = userService.show(10L);
        userDTO.setUserNickname("호날두");
        userDTO.setUserPassword("1234");
        userService.modify(userDTO);
    }

    //      삭제
    @Test
    public void removeTest(){
        userService.remove(5L);
    }

    //      조회
    @Test
    public void showTest(){
        log.info("유저 정보 : " + userService.show(10L));
    }

    //      전체 조회
    @Test
    public void showAllTest(){
//        userService.showAll().stream().map(UserVO::getUserName).forEach(log::info);
    }

}
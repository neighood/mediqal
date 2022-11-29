package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.UserDTO;
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

//      수정
    @Test
    public void setTest(){
        UserDTO userDTO = new UserDTO();
        userDTO.create(10L, "1234", "장보고", "덕배");
        userDAO.set(userDTO);
        log.info("유저 업데이트");
    }

//      삭제
    @Test
    public void removeTest(){
        userDAO.remove(9L);
    }

//      조회
    @Test
    public void findByIdTest(){
        log.info("findByIdTest : " + userDAO.findById(10L));
    }

//      전체 조회
    @Test
    public void findAllTest(){
        userDAO.findAll().stream().map(UserVO::getUserName).forEach(log::info);
    }

    @Test
    public void saveTest(){
        UserDTO userDTO = new UserDTO();
        userDTO.create(
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
        userDAO.save(userDTO);
    }

    @Test
    public void findPasswordByEmailTest(){
        log.info("userPassword" + userDAO.findPasswordByEmail("hgd@naver.com"));
    }

    @Test
    public void checkIdTest(){
        log.info("아이디 중복개수" + userDAO.checkId("ksy1@naver.com"));
    }

    @Test
    public void checkNicknameTest(){
        log.info("닉네임 중복 개수" + userDAO.checkNickname("장장보고"));
    }

    @Test
    public void loginTest(){log.info("로그인 회원번호" + userDAO.login("hgd@naver.com", "1234"));}

    @Test
    public void profileSelect(){
        log.info("유저 정보" + userDAO.profileSelect((long) 1));
    }

    @Test
    public void profileUpdate(){
        UserDTO userDTO = new UserDTO();
        userDTO.create((long) 1,
                "4321",
                "이순신",
                "이이순신");
        userDAO.profileUpdate(userDTO);
        log.info("유저 업데이트");
    }

    @Test
    public void profileDelete(){
        userDAO.profileDelete((long) 1);
        log.info("회원 탈퇴");
    }

}
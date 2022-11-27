package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e

@SpringBootTest
@Slf4j
public class UserDAOTest {

    @Autowired
<<<<<<< HEAD
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
=======
    private UserDAO userDAO;

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
        userDAO.save(userVO);
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

>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e
}
package com.mediqal.community.mapper;

<<<<<<< HEAD
=======

>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e
import com.mediqal.community.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {
<<<<<<< HEAD

=======
>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e
    @Autowired
    private UserMapper userMapper;

    @Test
<<<<<<< HEAD
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
=======
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

>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e
    }
}
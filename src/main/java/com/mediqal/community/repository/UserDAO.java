package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;
    //    회원가입
    public void save(UserVO userVO){userMapper.insert(userVO);}
    //    비밀번호 찾기
    public String findPasswordByEmail(String userEmail){
        return userMapper.findPassword(userEmail);
    }
    //    아이디 중복 검사
    public int checkId(String userEmail){
        return userMapper.checkId(userEmail);
    }
    //    닉네임 중복 검사
    public int checkNickname(String userNickname){
        return userMapper.checkNickname(userNickname);
    }
    //    로그인
    public int login(String userEmail, String userPassword){
        return userMapper.login(userEmail,userPassword);
    }
}

package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //    회원가입
    public void insert(UserVO userVO);
    //    비밀번호 찾기
    public String findPassword(String userEmail);
    //    아이디 중복 검사
    public int checkId(String userEmail);
    //    닉네임 중복 검사
    public int checkNickname(String userNickname);
    //    로그인
    public int login(String userEmail, String userPassword);

}

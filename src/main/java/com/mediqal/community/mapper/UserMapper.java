package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //    추가
    //    수정
    public void update(UserVO userVO);

    //    삭제
    public void delete(Long userNumber);

    //    조회
    public UserVO select(Long userNumber);

    //    전체 조회
    public List<UserVO> selectAll();

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

package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;
    //    추가

    //    수정
    public void set(UserDTO userDTO){
        userMapper.update(userDTO);
    }

    //    삭제
    public void remove(Long userNumber){
        userMapper.delete(userNumber);
    }

    //    조회
    public UserVO findById(Long userNumber){
        return userMapper.select(userNumber);
    }

    //    전체 조회
    public List<UserVO> findAll() {
        return userMapper.selectAll();
    }
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

    //  내 프로필
    public UserVO profileSelect(Long userNumber){
        return userMapper.profileSelect(userNumber);
    }
    // 유저 정보 수정
    public void profileUpdate(UserDTO userDTO){userMapper.profileUpdate(userDTO);}
    // 회원 탈퇴
    public void profileDelete(Long userNumber){userMapper.profileDelete(userNumber);}
    //    비밀번호 체크
    public int profileCheckPW(UserVO userVO){return userMapper.profileCheckPW(userVO);}
    //    비밀번호 변경
    public void profileUpdatePW(String userPasswordNew){userMapper.profileUpdatePW(userPasswordNew);}


}

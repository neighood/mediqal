package com.mediqal.community.repository;

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
    public void set(UserVO userVO){

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
    public List<UserVO> findAll(){
        return userMapper.selectAll();
    }
}

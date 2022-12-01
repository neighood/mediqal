package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.mapper.UserImgMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserImgDAO {
    private final UserImgMapper userImgMapper;

    //    조회
    public UserImgVO select(Long userNumber){
        return userImgMapper.select(userNumber);
    }
    //    파일 추가
    public void insert(UserImgVO userImgVO) {
        userImgMapper.insert(userImgVO);
    }

    //    파일 삭제
    public void delete(Long userImgNumber){
        userImgMapper.delete(userImgNumber);
    }

}

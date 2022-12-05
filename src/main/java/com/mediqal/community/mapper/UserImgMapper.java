package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserImgMapper {
    //    조회
    public UserImgVO select(Long userNumber);
    //    파일 수정
    public void update(UserImgVO userImgVO);
    //    파일 삭제
    public void delete(Long userImgNumber);
    //    추가
    public void insertUserImg(UserImgVO userImgVO);
}

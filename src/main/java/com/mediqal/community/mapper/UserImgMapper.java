package com.mediqal.community.mapper;

import com.mediqal.community.domain.vo.UserImgVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserImgMapper {
    //    추가
    public void insertUserImg(UserImgVO userImgVO);
}

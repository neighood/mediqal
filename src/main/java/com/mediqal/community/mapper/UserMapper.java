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
}

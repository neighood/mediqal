package com.mediqal.community.service;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.domain.dto.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //    추가
    public void register(UserDTO userDTO);
    //    수정
    public void modify(UserDTO userDTO);
    //    삭제
    public void remove(Long userNumber);
    //    조회
    public UserDTO show(Long userNumber);
    //    전체 조회
    public List<UserVO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();
}

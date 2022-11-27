package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("profile")
public class ProfileUserService implements UserService{
<<<<<<< HEAD

    @Override
    public void register(UserDTO userDTO) {

    }

    @Override
    public void modify(UserDTO userDTO) {

    }

    @Override
    public void remove(Long userNumber) {

    }

    @Override
    public UserVO show(Long userNumber) {
        return null;
    }

    @Override
    public List<UserVO> showAll(Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }
=======
//
//    @Override
//    public void register(UserDTO userDTO) {
//
//    }
//
//    @Override
//    public void modify(UserDTO userDTO) {
//
//    }
//
//    @Override
//    public void remove(Long userNumber) {
//
//    }
//
//    @Override
//    public UserDTO show(Long userNumber) {
//        return null;
//    }
//
//    @Override
//    public List<UserVO> showAll(Criteria criteria) {
//        return null;
//    }
//
//    @Override
//    public int getTotal() {
//        return 0;
//    }
>>>>>>> 9677e63debc280b7067b40622acfbc4e1238907e
}

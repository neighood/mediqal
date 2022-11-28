package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("admin")
public class AdminUserService implements UserService{
    private final UserDAO userDAO;

    @Override
    public void register(UserDTO userDTO) {

    }

    @Override
    public void modify(UserDTO userDTO) {

    }

    @Override
    public void remove(Long userNumber) {
        userDAO.remove(userNumber);
    }

    @Override
    public UserDTO show(Long userNumber) {
//        return userDAO.findById(userNumber);
        return null;
    }

    @Override
    public List<UserVO> showAll(Criteria criteria) {
        return userDAO.findAll();
    }

    @Override
    public int getTotal() {
        return 0;
    }
}

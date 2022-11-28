package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("sign") @Primary
public class SignUserService implements UserService{
    private final UserDAO userDAO;

    public void signUp(UserVO userVO) {
        userDAO.save(userVO);
    }

    public String findPassword(String userEmail) {
        return userDAO.findPasswordByEmail(userEmail);
    }

    public int checkId(String userEmail) {
        return userDAO.checkId(userEmail);
    }

    public int checkNickname(String userNickname) {
        return userDAO.checkNickname(userNickname);
    }

    public int login(String userEmail, String userPassword) {
        return userDAO.login(userEmail,userPassword);
    }

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
    public UserDTO show(Long userNumber) {
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
}

package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.repository.UserDAO;
import com.mediqal.community.repository.UserImgDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("admin")
public class AdminUserService implements UserService{
    private final UserDAO userDAO;
    private final UserImgDAO userImgDAO;

    @Override
    public void register(UserDTO userDTO){;}

    public void adminModify(UserVO userVO) {
        userDAO.adminSet(userVO);
    }

    @Override
    public void modify(UserDTO userDTO) {;}

    @Override
    public void remove(Long userNumber) {
        userDAO.remove(userNumber);
    }

    @Override
    public UserDTO show(Long userNumber) {
        UserDTO userDTO = new UserDTO();
        userDTO.create(userDAO.findById(userNumber));
        return userDTO;
    }

    public UserVO showTest(Long userNumber) {
        return userDAO.findById(userNumber);
    }

    @Override
    public List<UserVO> showAll(Criteria criteria) {
        return userDAO.findAll(criteria);
    }

    @Override
    public int getTotal() {
        return userDAO.findCountAll();
    }

    public UserImgVO adminGetUserImg(Long userNumber){
        return userImgDAO.adminSelect(userNumber);
    }
}

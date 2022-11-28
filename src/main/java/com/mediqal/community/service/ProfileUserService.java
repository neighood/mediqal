package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.repository.IllDAO;
import com.mediqal.community.repository.InterestDAO;
import com.mediqal.community.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("profile")
public class ProfileUserService implements UserService{

    private final UserDAO userDAO;
    private final InterestDAO interestDAO;
    private final IllDAO illDAO;


    @Override
    public void register(UserDTO userDTO) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(UserDTO userDTO) {
        userDAO.profileUpdate(userDTO);
        userDTO.getInterestVOs().stream().forEach(interestVO -> interestDAO.profileUpdate(interestVO));
        userDTO.getIllVOs().stream().forEach(illVO -> illDAO.profileUpdate(illVO));

    }

    @Override
    public void remove(Long userNumber) {
        userDAO.profileDelete(userNumber);
    }

    @Override
    public UserDTO show(Long userNumber) {
        UserDTO userDTO = new UserDTO();
        userDTO.create(userDAO.profileSelect(userNumber));
        userDTO.setInterestVOs(interestDAO.profileSelectAll(userNumber));
        userDTO.setIllVOs(illDAO.profileSelectAll(userNumber));
        return userDTO;
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

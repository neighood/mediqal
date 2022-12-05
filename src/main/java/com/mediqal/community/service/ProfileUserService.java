package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.repository.IllDAO;
import com.mediqal.community.repository.InterestDAO;
import com.mediqal.community.repository.UserDAO;
import com.mediqal.community.repository.UserImgDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("profile")
@Slf4j
public class ProfileUserService implements UserService{

    private final UserDAO userDAO;
    private final InterestDAO interestDAO;
    private final IllDAO illDAO;
    private final UserImgDAO userImgDAO;


    @Override
    public void register(UserDTO userDTO) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(UserDTO userDTO) {
        userDAO.profileUpdate(userDTO);
        UserImgVO userImgVO = userDTO.getUserImgVO();
        Optional.ofNullable(userImgVO).ifPresent(file -> {
            file.setUserNumber(userDTO.getUserNumber());
            userImgDAO.update(file);
        });
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
        userDTO.setUserImgVO(userImgDAO.select(userNumber));
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

    public boolean updatePW(UserVO userVO, String userPasswordNew){
        log.info("유저 비밀번호" + userVO.getUserPassword());
        log.info("유저 비밀번호" + userVO.getUserNumber());
        if(userDAO.profileCheckPW(userVO) == 1){
            userVO.setUserPassword(userPasswordNew);
            userDAO.profileUpdatePW(userVO);
            return true;
        }
        else{
            return false;
        }
    }


}

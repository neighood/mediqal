package com.mediqal.community.service;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.IllVO;
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
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("sign") @Primary
@Slf4j
public class SignUserService /*implements UserService*/{
    private final UserDAO userDAO;
    private final UserImgDAO userImgDAO;
    private final IllDAO illDAO;
    private final InterestDAO interestDAO;

//      회원가입
//    @Transactional(rollbackFor = Exception.class)
    public void signUp(UserDTO userDTO) {
        userDAO.save(userDTO);
//        userImgDAO.save(userDTO.getUserImgVO());

        /*userImg*/
        UserImgVO userImgVO = new UserImgVO();
        userImgVO.setUserNumber(userDTO.getUserNumber());
        userImgDAO.save(userImgVO);
//        Optional.ofNullable(userImg).ifPresent(img -> {
//            img.setUserNumber(userDTO.getUserNumber());
//            userImgDAO.save(img);
//        });

        /*ill*/
//        List<IllVO> ills = userDTO.getIllVOs();
//        Optional.ofNullable(ills).ifPresent(illList -> {
//            illList.forEach(ill -> {
//                ill.setUserNumber(userDTO.getUserNumber());
//                illDAO.save(ill);
//            });
//        });

        IllVO illVO = new IllVO();
        illVO.setUserNumber(userDTO.getUserNumber());
        illDAO.save(illVO);
        illDAO.save(illVO);
//        userDTO.getIllVOs().stream().forEach(illVO -> {
//            illVO.setUserNumber(userDTO.getUserNumber());
//            illDAO.save(illVO);
//        });
        /*interest*/
//        List<InterestVO> interests = userDTO.getInterestVOs();
//        Optional.ofNullable(interests).ifPresent(interestList -> {
//            interestList.forEach(interest -> {
//                interest.setUserNumber(userDTO.getUserNumber());
//                interestDAO.save(interest);
//            });
//        });

        InterestVO interestVO = new InterestVO();
        interestVO.setUserNumber(userDTO.getUserNumber());
        interestDAO.save(interestVO);
        interestDAO.save(interestVO);
//        userDTO.getInterestVOs().stream().forEach(interestVO -> {
//            interestVO.setUserNumber(userDTO.getUserNumber());
//            interestDAO.save(interestVO);
//        });
    }

//      비밀번호 찾기
    public String findPassword(String userEmail) {
        return userDAO.findPasswordByEmail(userEmail);
    }
//      아이디 중복검사
    public int checkId(String userEmail) {
        return userDAO.checkId(userEmail);
    }
//      닉네임 중복검사
    public int checkNickname(String userNickname) {
        return userDAO.checkNickname(userNickname);
    }
//      로그인
    public long login(String userEmail, String userPassword) {
        return userDAO.login(userEmail,userPassword);
    }

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
}

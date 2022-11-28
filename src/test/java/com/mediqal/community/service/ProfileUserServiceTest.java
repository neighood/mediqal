package com.mediqal.community.service;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.IllVO;
import com.mediqal.community.domain.vo.InterestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class ProfileUserServiceTest {

    @Autowired @Qualifier("profile")
    private UserService userService;

    @Test
    public void profileSelect(){
        log.info("유저 정보" + userService.show((long) 1));
    }

    @Test
    public void profileUpdate(){
        UserDTO userDTO = new UserDTO();
        List<InterestVO> interestVOs = new ArrayList<>();
        List<IllVO> illVOs = new ArrayList<>();

        InterestVO interestVO1 = new InterestVO();
        InterestVO interestVO2 = new InterestVO();
        interestVO1.setInterestNumber((long)1);
        interestVO1.setInterestName("아파");
        interestVOs.add(interestVO1);
        interestVO2.setInterestNumber((long)2);
        interestVO2.setInterestName("아파");
        interestVOs.add(interestVO2);

        IllVO illVO1 = new IllVO();
        IllVO illVO2 = new IllVO();
        illVO1.setIllNumber((long)1);
        illVO1.setIllName("감기");
        illVOs.add(illVO1);
        illVO2.setIllNumber((long)2);
        illVO2.setIllName("감기");
        illVOs.add(illVO2);

        userDTO.create((long) 1,
                "4321",
                "이순신",
                "이이순신");

        userDTO.setInterestVOs(interestVOs);
        userDTO.setIllVOs(illVOs);
        userService.modify(userDTO);
        log.info("유저 업데이트");
    }

    @Test
    public void profileDelete(){
        userService.remove((long) 1);
        log.info("유저 회원탈퇴");
    }

}

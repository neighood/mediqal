package com.mediqal.community.repository;

import com.mediqal.community.domain.dto.ConfirmDTO;
import com.mediqal.community.domain.vo.ConfirmVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ConfirmDAOTest {

    @Autowired
    private ConfirmDAO confirmDAO;

    @Test
    public void insert(){
        ConfirmDTO confirmDTO = new ConfirmDTO();
        confirmDTO.setUserNumber((long) 1);
        confirmDAO.insert(confirmDTO);
    }
}

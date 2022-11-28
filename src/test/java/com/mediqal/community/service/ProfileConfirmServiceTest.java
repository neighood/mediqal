package com.mediqal.community.service;

import com.mediqal.community.domain.dto.ConfirmDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProfileConfirmServiceTest {

    @Autowired @Qualifier("profile")
    private ConfirmService confirmService;

    @Test
    public void insert(){
        ConfirmDTO confirmDTO = new ConfirmDTO();
        confirmDTO.setUserNumber((long) 1);
        confirmService.register(confirmDTO);
    }
}

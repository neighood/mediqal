package com.mediqal.community.mapper;

import com.mediqal.community.domain.dto.ConfirmDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ConfirmMapperTest {

    @Autowired
    private ConfirmMapper confirmMapper;

    @Test
    public void insert(){
        ConfirmDTO confirmDTO = new ConfirmDTO();
        confirmDTO.setUserNumber((long) 1);
        confirmMapper.insert(confirmDTO);
    }

}

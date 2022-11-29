package com.mediqal.community.repository;

import com.mediqal.community.domain.vo.IllVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class IllDAOTest {

    @Autowired
    private  IllDAO illDAO;

    @Test
    public void ProfileSelectAllTest(){
        illDAO.profileSelectAll((long) 1).stream().map(IllVO::getIllName).forEach(log::info);
    }

    @Test
    public void profileUpdate(){
        IllVO illVO = new IllVO();
        illVO.setIllNumber((long) 2);
        illVO.setIllName("편두통");
        illDAO.profileUpdate(illVO);
    }

    @Test
    public void saveTest(){
        IllVO illVO = new IllVO();
        illVO.create(3L,  "코로나");
        illDAO.save(illVO);
    }
}

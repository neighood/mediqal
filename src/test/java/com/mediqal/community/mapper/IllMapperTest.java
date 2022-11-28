package com.mediqal.community.mapper;


import com.mediqal.community.domain.vo.IllVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class IllMapperTest {

    @Autowired
    private IllMapper illMapper;

    @Test
    public void profileSelectAllTest(){
        illMapper.profileSelectAll((long) 1).stream().map(IllVO::getIllName).forEach(log::info);
    }

    @Test
    public void profileUpdate(){
        IllVO illVO = new IllVO();
        illVO.setIllNumber((long) 1);
        illVO.setIllName("편두통");
        illMapper.profileUpdate(illVO);
    }


}
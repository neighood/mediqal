package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IllVO {
    private Long illNumber;

    private Long userNumber;

    private String illName;

    public void create(Long userNumber, String illName){
        this.userNumber = userNumber;
        this.illName = illName;
    }
}

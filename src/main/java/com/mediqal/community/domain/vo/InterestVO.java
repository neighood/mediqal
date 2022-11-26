package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class InterestVO {
    private Long interestNumber;

    private Long userNumber;

    private String interestName;
}

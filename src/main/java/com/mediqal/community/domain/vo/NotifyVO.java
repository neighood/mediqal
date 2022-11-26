package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class NotifyVO {
    private Long notifyNumber;

    private Long boardNumber;

    private Long userNumber;

    private Long notifyStatus;
}

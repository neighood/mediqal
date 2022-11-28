package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CertifyVO {
    private Long certifyNumber;

    private Long confirmNumber;

    private Long userNumber;

    private String certifyName;

    private String certifyUploadPath;

    private String certifyUuid;

    private boolean certifyImageCheck;

    private Long certifySize;
}

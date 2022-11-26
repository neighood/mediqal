package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.CertifyVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ConfirmDTO {
    private Long confirmNumber;

    private Long userNumber;

    private List<CertifyVO> certifyVOs;
}

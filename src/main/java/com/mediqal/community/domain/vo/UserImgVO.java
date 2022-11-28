package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserImgVO {
    private Long userImgNumber;

    private Long userNumber;

    private String userImgName;

    private String userImgUploadPath;

    private String userImgUuid;

    private boolean userImgImageCheck;

    private Long userImgSize;
}

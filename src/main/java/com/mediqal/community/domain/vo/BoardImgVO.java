package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardImgVO {
    private Long boardImgNumber;

    private Long boardNumber;

    private Long userNumber;

    private String boardImgName;

    private String boardImgUploadPath;

    private String boardImgUuid;

    private boolean boardImgImageCheck;

    private Long boardImgSize;
}

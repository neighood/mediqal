package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardVO {
    private Long boardNumber;

    private Long userNumber;

    private String boardTitle;

    private String boardContent;

    private String boardCategory;

    private String boardRegisterDate;

    private String boardUpdateDate;

    private Long boardView;
}

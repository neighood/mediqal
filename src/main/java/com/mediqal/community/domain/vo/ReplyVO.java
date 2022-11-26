package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long replyNumber;

    private Long boardNumber;

    private Long userNumber;

    private String replyContent;

    private String replyRegisterDate;

    private String replyUpdateDate;
}

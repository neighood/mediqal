package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LikeVO {
    private Long likeNumber;

    private Long boardNumber;

    private Long userNumber;
}

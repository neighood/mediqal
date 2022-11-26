package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TagVO {
    private Long tagNumber;

    private Long boardNumber;

    private String tagName;
}

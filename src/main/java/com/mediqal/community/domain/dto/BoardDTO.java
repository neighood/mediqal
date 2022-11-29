package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardDTO {
    private Long boardNumber;

    private Long userNumber;

    private String boardTitle;

    private String boardContent;

    private String boardCategory;

    private String boardRegisterDate;

    private String boardUpdateDate;

    private Long boardView;

    private UserVO userVO;

    private UserImgVO userImgVO;

    private LikeVO likeVO;

    private int likeCount;

    private int replyCount;

    private List<BoardImgVO> boardImgVOs;

    private List<TagVO> tagVOs;
}

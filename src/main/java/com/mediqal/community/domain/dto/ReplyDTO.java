package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.ReplyVO;
import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.domain.vo.UserVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ReplyDTO {

    private Long replyNumber;

    private Long boardNumber;

    private Long userNumber;

    private String replyContent;

    private String replyRegisterDate;

    private String replyUpdateDate;

    private String userNickname;

    private UserImgVO userImgVO;

}

package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserDTO {
    private Long userNumber;

    private String userEmail;

    private String userPassword;

    private String userName;

    private String userNickname;

    private String userAuthType;

    private String userType;

    private String userDateJoin;

    private String userDateRecent;

    private String userDateVerification;

    private String userEmailCheck;

    private UserImgVO userImgVO;

    private List<BoardVO> boardVOs;

    private List<ReplyVO> replyVOs;

    private List<InterestVO> interestVOs;

    private List<IllVO> illVOs;

    private List<ConfirmVO> confirmVOs;

    private List<LikeVO> likeVOs;


}

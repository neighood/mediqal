package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SplittableRandom;

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

    public void create(Long userNumber, String userPassword, String userName, String userNickname) {
        this.userNumber = userNumber;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
    }

    public void create(UserVO userVO) {
        this.userNumber = userVO.getUserNumber();
        this.userPassword = userVO.getUserPassword();
        this.userName = userVO.getUserName();
        this.userNickname = userVO.getUserNickname();
    }

    public void create(Long userNumber, List<InterestVO> interestVOs) {
        this.userNumber = userNumber;
        this.interestVOs = interestVOs;
    }

    public void create(String userEmail, String userPassword, String userName, String userNickname, String userAuthType, String userType, String userDateJoin, String userDateRecent, String userDateVerification, String userEmailCheck){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userAuthType = userAuthType;
        this.userType = userType;
        this.userDateJoin = userDateJoin;
        this.userDateRecent = userDateRecent;
        this.userDateVerification = userDateVerification;
        this.userEmailCheck = userEmailCheck;
    }

}

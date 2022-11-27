package com.mediqal.community.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVO {
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

    public void create(Long userNumber, String userEmail, String userPassword, String userName, String userNickname, String userAuthType, String userType, String userDateJoin, String userDateRecent, String userDateVerification, String userEmailCheck) {
        this.userNumber = userNumber;
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

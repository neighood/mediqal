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

}

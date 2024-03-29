package com.ktds.questionformentoring.login.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class LoginDTO {
    /* Access token */
    private String accessToken;
    /* Refresh token */
    private String refreshToken;
}

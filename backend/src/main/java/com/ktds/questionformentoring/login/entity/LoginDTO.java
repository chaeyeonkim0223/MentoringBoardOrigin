package com.ktds.questionformentoring.login.entity;

import com.ktds.questionformentoring.member.entity.MemberDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@ToString
@Data
//@RedisHash("user")
public class LoginDTO {
    /* Access token */
    private String accessToken;
    /* Refresh token */
    private String refreshToken;
    /* Member Info */
    private MemberDTO user;
    //@Id
    //private String id;
}

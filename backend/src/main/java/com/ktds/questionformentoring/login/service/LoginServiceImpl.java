package com.ktds.questionformentoring.login.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ktds.questionformentoring.login.mapper.LoginMapper;
import com.ktds.questionformentoring.member.entity.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${environments.jwt.secretkey}")
    private String SECRET_KEY; // 서명에 사용할 secretKey
    @Value("${environments.jwt.expiretime}")
    private long EXPIRE_TIME; // 토큰 사용가능 시간, 30분

    @Autowired
    private LoginMapper loginMapper;

    // 토큰 생성하는 메서드
    @Override
    public String createToken(MemberDTO memberDto) { // 토큰에 담고싶은 값 파라미터로 가져오기
        return Jwts.builder()
                .setHeaderParam("typ", "JWT") // 토큰 타입
                .setSubject("userToken") // 토큰 제목
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 토큰 유효시간
                .claim("user", memberDto) // 토큰에 담을 데이터
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes()) // secretKey를 사용하여 해싱 암호화 알고리즘 처리
                .compact(); // 직렬화, 문자열로 변경
    }

    // 토큰에 담긴 정보를 가져오기 메서드
    @Override
    public Map<String, Object> getInfo(String token) throws Exception {
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token); // secretKey를 사용하여 복호화
        } catch(Exception e) {
            throw new Exception();
        }

        return claims.getBody();
    }

    // interceptor에서 토큰 유효성을 검증하기 위한 메서드
    @Override
    public void checkValid(String token) {
        Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token);
    }

    @Override
    public boolean checkValidUser(MemberDTO memberDto) {

        MemberDTO DBUser = null;
        try {
            DBUser = this.findOne(memberDto); // DB에 저장되어 있는 사용자 정보 가져와서 조회
        } catch (Exception e) {
            System.out.println(e);
        }

        if(DBUser != null && DBUser.getLoginId().equals(memberDto.getLoginId()) && DBUser.getLoginPwd().equals(memberDto.getLoginPwd())) { // 유효한 사용자일 경우
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<MemberDTO> findAll() {
        return loginMapper.findAll();
    }

    @Override
    public MemberDTO findOne(MemberDTO memberDTO) {
        return loginMapper.findOne(memberDTO.getLoginId(), memberDTO.getLoginPwd());
    }
}
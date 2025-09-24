package com.spring.mallapi.controller;

import com.spring.mallapi.util.CustomJWTException;
import com.spring.mallapi.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class APIRefreshController {
    @RequestMapping(value="/api/member/refresh", method= {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> refresh(@RequestHeader("Authorization") String authHeader, @RequestParam("refreshToken") String refreshToken) {
        if(refreshToken == null) {
            throw new CustomJWTException("NULL_REFRESH");
        }
        if(authHeader == null || authHeader.length() <7) {
            throw new CustomJWTException("INVALID_STRING");
        }

        String accessToken = authHeader.substring(7);
        //토큰이 만료되지 않은 경우
        if(checkExpiredToken(accessToken) == false) {
            return Map.of("accessToken",accessToken, "refreshToken", refreshToken);
        }

        //refresh토큰 검증
        Map<String,Object> claims = JWTUtil.validateToken(refreshToken);
        log.info("refresh.....claims:{}",claims);
        String newAccessToken = JWTUtil.generateToken(claims,10);
        String newRefreshToken = checkTime((Integer) claims.get("exp")) == true ? JWTUtil.generateToken(claims,60*24) : refreshToken;

        return Map.of("accessToken",newAccessToken,"refreshToken",newRefreshToken);
    }
        //시간이 1시간 미만으로 남은 경우
    private boolean checkTime(Integer exp) {
        //JWT exp를 날짜로 변환
        Date expDate = new Date((long) exp*1000);
        //현재 시간과의 차이 계산 - 밀리세컨즈
        long gap = expDate.getTime() - System.currentTimeMillis();
        //분단위 계산
        long leftMin = gap / (1000*60);
        //1시간도 안남았는지
        return leftMin < 60;
    }
    private boolean checkExpiredToken(String token) {
        try {
            JWTUtil.validateToken(token);
        } catch (CustomJWTException ex) {
            if(ex.getMessage().equals("Expired")){
                return true;
            }
        }
        return false;
    }
}

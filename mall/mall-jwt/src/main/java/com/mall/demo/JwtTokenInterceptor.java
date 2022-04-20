package com.mall.demo;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //获取请求头的令牌
        String token = request.getHeader("token");

        try {
            JWTUtil.verify(token);      //The authentication token
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        map.put("state", false);      //Set the state
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }


}

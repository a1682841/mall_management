package com.mall.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    /**
     * 演示demo中salt硬编码，实际开发中应取用户的随机盐
     */
    private static String salt = "1q2w3e";
    /**
     * 生成token
     * @param map  //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
        // 设置token的有效期为15秒
        instance.add(Calendar.SECOND,1200);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(salt)).toString();
    }
    /**
     * 验证token
     * @param token
     * @return
     */
    public static void verify(String token){
      //  JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
    }
    /**
     * 获取token中payload
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
    }
}

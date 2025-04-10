package com.itheima;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/11:24
 * @Description: jwt令牌测试
 */
public class JwtTest {

    /**
     * 生成jwt令牌
     */
    @Test
    public void testGenerateJwt(){

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
             objectObjectHashMap.put("id",1);
             objectObjectHashMap.put("username","admin");
        String compact = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==")// 生成令牌
                .addClaims(objectObjectHashMap) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间))
                .compact();// 生成令牌
        System.out.println(compact);
    }
}

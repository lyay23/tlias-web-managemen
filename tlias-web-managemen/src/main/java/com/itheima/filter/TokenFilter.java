package com.itheima.filter;

import com.itheima.util.CurrentHolder;
import com.itheima.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/15:03
 * @Description: 令牌校验Filter的拦截器
 */
@Slf4j
@WebFilter(urlPatterns = {"/*"}) // 拦截所有请求
public class TokenFilter implements Filter {

    /**
     *  拦截前端请求，判断请求头中是否包含token
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取到请求路径
        // /login
        String path = request.getRequestURI();

        // 2.判断请求路径是否以/login结尾，判断是不是登录，如果是就放行

        if (path.contains("/login")){
            log.info("登录请求，放行");
            filterChain.doFilter(request,response);
            return;
        }

        // 3.获取请求头中的token
        String token = request.getHeader("token");

        // 4.判断token是否存在，不存在就返回未登录信息401，存在就放行
        if (token==null || token.isEmpty()){
            log.info("令牌为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 5.如果token存在，就放行，并且将token解析，获取其中的用户信息，校验不通过返回401
        try {
            // 解析token 获取到token的第二部分
            Claims claims = JwtUtils.parseToken(token);

            // 获取到用户id
            Integer id = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(id);
            log.info("当前登录员工ID：{},将其存入ThreadLocal", id);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        // 6.如果token校验通过，将用户放行
        log.info("令牌校验通过");
        filterChain.doFilter(request,response);

        // 7.删除ThreadLocal中的数据
        CurrentHolder.remove();


    }

}
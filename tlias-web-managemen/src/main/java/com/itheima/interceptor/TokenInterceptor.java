package com.itheima.interceptor;

import com.itheima.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/16:36
 * @Description: 拦截器
 */
@Slf4j
//@Component
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 在目标方法运行之前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.获取到请求路径
        // /login
        String path = request.getRequestURI();

        // 2.判断请求路径是否以/login结尾，判断是不是登录，如果是就放行

        if (path.contains("/login")){
            log.info("登录请求，放行");
            return true;
        }

        // 3.获取请求头中的token
        String token = request.getHeader("token");

        // 4.判断token是否存在，不存在就返回未登录信息401，存在就放行
        if (token==null || token.isEmpty()){
            log.info("令牌为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 5.如果token存在，就放行，并且将token解析，获取其中的用户信息，校验不通过返回401
        try {
            // 解析token
            JwtUtils.parseToken(token);
            log.info("令牌解析成功");
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 6.如果token校验通过，将用户放行
        log.info("令牌校验通过");
        return true;


}
}

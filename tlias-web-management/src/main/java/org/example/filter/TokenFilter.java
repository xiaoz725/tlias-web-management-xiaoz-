package org.example.filter;

import io.jsonwebtoken.Claims;
import org.example.utils.CurrentHolder;
import org.example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.io.IOException;

/**
 * 令牌校验过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1. 获取请求url。
        String url = request.getRequestURL().toString();

        //2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if(url.contains("login")|| url.contains("/log/")){ //登录请求
            log.info("登录请求 , 直接放行");
            filterChain.doFilter(request, response);
            return;
        }

        //3. 获取请求头中的令牌（token）。
        String token = request.getHeader("token");

        //4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if(token == null || token.isEmpty()){ //jwt为空
            log.info("获取到jwt令牌为空, 响应401状态码");
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        //5. 解析token，如果解析失败，返回错误结果（未登录）。
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前登录员工ID:{},将其存入ThreadLocal",empId);
        } catch (Exception e) {
            log.info("解析令牌失败, 响应401状态码");
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return;
        }

        //6. 放行。
        log.info("令牌合法, 放行");
        filterChain.doFilter(request , response);

        //7. 清空当前线程绑定的id
        CurrentHolder.remove();
    }

}
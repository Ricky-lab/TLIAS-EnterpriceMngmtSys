package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //1. url asking request
        String url = req.getRequestURL().toString();

        //2. Judge if url includes "/login" path, if yes, pass the chain and verify the account
        if(url.contains("login")){
            log.info("Accessing the login process, pass the chain");
            filterChain.doFilter(servletRequest, servletResponse);
        }

        //3. Get the token from request header
        String token = req.getHeader("token");

        //4. Judge if the token exists
        if(!StringUtils.hasLength(token)){
            log.info("Empty token, block the request and return");

            //change the type of result to json type for printing
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //5. Judge if the token is valid
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Verify the token failed, return errors.");

            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }


         //6. Pass the chains
        log.info("Verified successfully, pass the chain. ");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

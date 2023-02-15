package com.techscroll.frinlen.exception;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.techscroll.frinlen.response.error.ErrorResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErrorResponse errorResponse;
        if(authException instanceof InvalidTokenException){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse = new ErrorResponse("Error", "Invalid Token! Please login", HttpServletResponse.SC_UNAUTHORIZED);
        }else if(authException instanceof TokenExpireException){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse = new ErrorResponse("Error", "Token is expired! Please login", HttpServletResponse.SC_UNAUTHORIZED);
        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorResponse = new ErrorResponse("Error", "You are unauthorized! Please login", HttpServletResponse.SC_UNAUTHORIZED);

        }
        response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
    }
}

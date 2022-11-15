package com.techscroll.frinlen.Service.Auth;

import com.techscroll.frinlen.dto.user.request.LoginRequestDto;
import com.techscroll.frinlen.dto.user.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto);
}

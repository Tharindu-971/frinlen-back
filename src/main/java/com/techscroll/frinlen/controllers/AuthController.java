package com.techscroll.frinlen.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.techscroll.frinlen.Service.Auth.AuthService;
import com.techscroll.frinlen.dto.user.request.LoginRequestDto;
import com.techscroll.frinlen.dto.user.response.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techscroll.frinlen.models.Role;
import com.techscroll.frinlen.models.User;
import com.techscroll.frinlen.payload.request.LoginRequest;
import com.techscroll.frinlen.payload.request.SignupRequest;
import com.techscroll.frinlen.payload.response.JwtResponse;
import com.techscroll.frinlen.payload.response.MessageResponse;
import com.techscroll.frinlen.repository.RoleRepository;
import com.techscroll.frinlen.repository.UserRepository;
import com.techscroll.frinlen.security.services.UserDetailsImpl;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
  @Autowired
  private AuthService authService;
  @PostMapping("/auth/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto){
    return new ResponseEntity(authService.login(loginRequestDto), HttpStatus.OK);
  }

}

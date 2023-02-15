package com.techscroll.frinlen.service.auth;

import com.techscroll.frinlen.entity.role.Role;
import com.techscroll.frinlen.entity.role.RoleName;
import com.techscroll.frinlen.entity.user.User;
import com.techscroll.frinlen.repository.user.UserRepository;
import com.techscroll.frinlen.request.auth.AuthenticationRequest;
import com.techscroll.frinlen.request.auth.RegisterRequest;
import com.techscroll.frinlen.response.auth.AuthenticationResponse;
import com.techscroll.frinlen.security.config.SecurityUser;
import com.techscroll.frinlen.utils.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(new Role(RoleName.ROLE_USER)))
                .build();
        userRepository.save(user);
        Map<String,Object> roles = new HashMap<>();
        roles.put("roles",user.getRoles().stream().map(e ->e.getRole().toString()).collect(Collectors.toList()));
        var token = jwtService.generateToken(roles,new SecurityUser(user));
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("User name not found!"));
        Map<String,Object> roles = new HashMap<>();
        roles.put("roles",user.getRoles().stream().map(e ->e.getRole().toString()).collect(Collectors.toList()));
        roles.put("id",user.getId());
        roles.put("firstName",user.getFirstName()   );
        var token = jwtService.generateToken(roles,new SecurityUser(user));
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}

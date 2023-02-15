package com.techscroll.frinlen.service.auth;

import com.techscroll.frinlen.request.auth.AuthenticationRequest;
import com.techscroll.frinlen.request.auth.RegisterRequest;
import com.techscroll.frinlen.response.auth.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}

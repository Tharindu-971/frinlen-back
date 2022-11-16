package com.techscroll.frinlen.Service.Auth;

import com.techscroll.frinlen.dto.user.request.LoginRequestDto;
import com.techscroll.frinlen.dto.user.response.LoginResponseDto;
import com.techscroll.frinlen.models.Role;
import com.techscroll.frinlen.models.User;
import com.techscroll.frinlen.repository.RoleRepository;
import com.techscroll.frinlen.repository.UserRepository;
import com.techscroll.frinlen.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto){
        System.out.println("Otu");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getEmail(), loginRequestDto.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            System.out.println(user.toString());
            String accessToken = jwtUtil.generateAccessToken(user);
            System.out.println("Otu   edd       "+accessToken);

            System.out.println(     "Roles"+ user.getRoles().toString());
            LoginResponseDto response = new LoginResponseDto(user.getId(),user.getFirstName(),user.getEmail(),setToStringArr(user.getRoles()), accessToken);


            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

//    @Override
//    public List<UserResponseDto> getAllUsers(){
//        List<User> users = userRepository.findAll();
//        List<UserResponseDto> results = new ArrayList<>();
//        for(User user:users){
//            UserResponseDto res = entityToUserResponseDto(user);
//            results.add(res);
//        }
//        return results;
//    }

//    @Override
//    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto){
//        User user = userCreateRequestDtoToEntity(userCreateRequestDto);
//        userRepository.save(user);
//        return new UserResponseDto().builder()
//                .email(user.getEmail())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .build();
//    }

//    private User userCreateRequestDtoToEntity(UserCreateRequestDto userCreateRequestDto) {
//
//        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//        Role role = roleRepository.findByName("ROLE_USER");
//
//
//        User user = new User();
//        user.setFirstName(userCreateRequestDto.getFirstName());
//        user.setLastName(userCreateRequestDto.getLastName());
//        user.setEmail(userCreateRequestDto.getEmail());
//        user.setActive(true);
//        user.addRole(role);
//
//
//        return user;
//
//
//    }
//
//    private UserResponseDto entityToUserResponseDto(User user) {
//
//        return new UserResponseDto().builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .build();
//    }


    private String[] setToStringArr(Set<Role> roles){
        // Create String[] of size of setOfString
        String[] arrayOfString = new String[roles.size()];

        // Copy elements from set to string array
        // using advanced for loop
        int index = 0;
        for (Role str : roles)
            arrayOfString[index++] = str.getName();

        // return the formed String[]
        return arrayOfString;
    }
}

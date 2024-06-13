package com.techprimelab.project.authentication;

import com.techprimelab.project.dto.RegisterReq;
import com.techprimelab.project.dto.UserAuthReq;
import com.techprimelab.project.dto.UserAuthRes;
import com.techprimelab.project.entity.User;
import com.techprimelab.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserAuthRes register(RegisterReq req) {
        var user = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();

        try {
            User temp = repository.save(user);
            var jwtToken = jwtUtil.generateToken(user);
            return UserAuthRes.builder()
                    .success(true)
                    .message("New project added successfully")
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            return UserAuthRes.builder()
                    .success(false)
                    .message("Project not added")
                    .token(null)
                    .build();
        }
    }

    public UserAuthRes authenticate(UserAuthReq req) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        req.getEmail(),
//                        req.getPassword()
//                )
//        );
//        try {
        var user = repository.findByEmail(req.getEmail()).orElseThrow();
        var jwtToken = jwtUtil.generateToken(user);
        return UserAuthRes.builder()
                .message("Valid User")
                .success(true)
                .token(jwtToken)
                .build();
//        } catch (Exception e) {
//            return UserAuthRes.builder()
//                    .message("Invalid User")
//                    .success(false)
//                    .token(null)
//                    .build();
//        }
    }
}


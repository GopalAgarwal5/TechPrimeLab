package com.techprimelab.project.restController;

import com.techprimelab.project.authentication.AuthService;
import com.techprimelab.project.dto.RegisterReq;
import com.techprimelab.project.dto.UserAuthReq;
import com.techprimelab.project.dto.UserAuthRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginRestController {
    private final AuthService service;

    public LoginRestController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthRes> register(@RequestBody RegisterReq req) {
        return ResponseEntity.ok(service.register(req));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthRes> authenticate(@RequestBody UserAuthReq req) {
        return ResponseEntity.ok(service.authenticate(req));
    }
}

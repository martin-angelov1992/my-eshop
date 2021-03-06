package com.martin.eshop.controller;

import com.martin.eshop.service.jwt.JwtTokenProvider;
import com.martin.eshop.model.auth.JwtAuthenticationResponse;
import com.martin.eshop.model.auth.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")
public class LoginController
{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping ("/signin")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest ) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
                                                                          );

        SecurityContextHolder
            .getContext( ).setAuthentication( authentication );

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse( jwt) );
    }
}

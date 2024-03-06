package com.pedro.demo.controllers;

import com.pedro.demo.dto.AuthenticationDTO;
import com.pedro.demo.dto.RegisterDTO;
import com.pedro.demo.entities.User;
import com.pedro.demo.repositories.UserRepository;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);


        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO dto) {

        if(repository.findByLogin(dto.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User(dto.login(), encryptedPassword, dto.role());

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }
}

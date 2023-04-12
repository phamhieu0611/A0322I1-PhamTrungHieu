package com.example.a04cinema.controller;

import com.example.a04cinema.jwt.JwtTokenProvider;
import com.example.a04cinema.entity.Account;
import com.example.a04cinema.model.reponse.JwtReponse;
import com.example.a04cinema.model.reponse.MessageReponse;
import com.example.a04cinema.model.request.LoginRequest;
import com.example.a04cinema.model.request.SignupRequest;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.a04cinema.service.AccountService;
import com.example.a04cinema.service.RoleService;
import com.example.a04cinema.service.impl.JwtAccountDetailsImpl;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(loginRequest.getUsername());
        JwtAccountDetailsImpl userDetails = (JwtAccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        Account account = accountService.findAccountByUserName(loginRequest.getUsername());

        return ResponseEntity.ok(
                new JwtReponse(
                        jwt,
                        userDetails.getUsername(),
                        roles)
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest)
            throws MessagingException, UnsupportedEncodingException {
        Account account = new Account(signupRequest.getUsername(),
                passwordEncoder.encode(signupRequest.getPassword()));

        accountService.addNew(account.getUsername(), account.getPassword());
        String usernameAfterCreated = account.getUsername();
        roleService.setDefaultRole(usernameAfterCreated, 1);
        return ResponseEntity.ok(new MessageReponse("ok!"));
    }
}

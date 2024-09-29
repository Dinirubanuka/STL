package com.stl.identity.controller;

import com.stl.identity.dto.request.RegisterRequestDTO;
import com.stl.identity.dto.response.ApiResponse;
import com.stl.identity.dto.response.UserResponseDTO;
import com.stl.identity.entity.User;
import com.stl.identity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> register(
            @RequestBody @Valid User request
    ) {
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),authService.registerUser(request),"success") ;
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> testController(){
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),"THIS IS A TEST","success"),HttpStatus.OK);
    }


}

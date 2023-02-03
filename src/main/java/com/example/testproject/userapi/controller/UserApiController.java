package com.example.testproject.userapi.controller;

import com.example.testproject.userapi.dto.UserSignUpDTO;
import com.example.testproject.userapi.dto.UserSignUpResponseDTO;
import com.example.testproject.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users/api")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignUpDTO signUpDTO){
        log.info("/users/api/signup POST! - {}", signUpDTO);

        UserSignUpResponseDTO responseDTO = userService.create(signUpDTO);
            return ResponseEntity
                    .ok()
                    .body(responseDTO);
    }

}

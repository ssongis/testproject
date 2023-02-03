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

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody UserSignUpDTO userSignUpDTO){
        log.info("/users/api/signup POST! - {}", userSignUpDTO);

//        UserSignUpResponseDTO responseDTO = userService.create(userSignUpDTO);
//        return ResponseEntity
//                    .ok()
//                    .body(responseDTO);
        try {
            UserSignUpResponseDTO responseDTO = userService.create(userSignUpDTO);
            return ResponseEntity
                    .ok()
                    .body(responseDTO);
        }catch (RuntimeException e) {
            log.warn("중복되었습니다. 이메일을 다시 작성해주세요.");
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}

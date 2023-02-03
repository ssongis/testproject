package com.example.testproject.userapi.service;

import com.example.testproject.userapi.dto.UserSignUpDTO;
import com.example.testproject.userapi.dto.UserSignUpResponseDTO;
import com.example.testproject.userapi.entity.UserEntity;
import com.example.testproject.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    // 회원가입 처리
    public UserSignUpResponseDTO create(final UserSignUpDTO userSignUpDTO){ //UserSignUpResponseDTO로 리턴

        // 엔터티로 변환한 값 저장
        UserEntity savedUser = userRepository.save(userSignUpDTO.toEntity());
        log.info("회원 가입 성공!! - user_id : {}",savedUser.getId());

        // save의 리턴 결과 저장
        return new UserSignUpResponseDTO(savedUser);
    }
}

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
        final String email = userSignUpDTO.getEmail(); // 회원가입한 email 정보 조회

        // 이메일 중복 확인
        if(userRepository.existsByEmail(email)){ // email 값이 1이면 중복 (existByEmail은 boolean 타입)
            log.warn("Email already exists - {}", email);
            throw new RuntimeException("중복된 이메일입니다.");
        }

        // 엔터티로 변환한 값 저장
        UserEntity savedUser = userRepository.save(userSignUpDTO.toEntity());
        log.info("회원 가입 성공!! - user_id : {}",savedUser.getId());

        // save의 리턴 결과 저장
        return new UserSignUpResponseDTO(savedUser);
    }


}

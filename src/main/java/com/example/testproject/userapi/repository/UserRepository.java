package com.example.testproject.userapi.repository;

import com.example.testproject.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // 이메일로 회원 조회
    // UserEntity에서 email 조회
    UserEntity findByEmail(String email);
    // 이메일 중복 검사
    // UserEntity에서 email 중복을 boolean 값으로 가져와서 존재여부 확인
    boolean existsByEmail(String email);
}

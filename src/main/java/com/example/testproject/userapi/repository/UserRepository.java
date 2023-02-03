package com.example.testproject.userapi.repository;

import com.example.testproject.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

//    UserEntity findByEmail(String email);

    // 이메일 중복 검사
    // select count(*) from tbl_user where email=? => unique는 0 또는 1, 0이면 중복x => false
//    @Query("select count(*) from UserEntity u where email=?1")
    // UserEntity에서 email 중복을 boolean 값으로 가져와서 존재여부 확인
//    boolean existsByEmail(String email);

}

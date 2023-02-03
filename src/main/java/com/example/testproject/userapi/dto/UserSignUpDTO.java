package com.example.testproject.userapi.dto;

import com.example.testproject.userapi.entity.UserEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "email")
@Builder
public class UserSignUpDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max=20)
    private String password;

    @NotBlank
    @Size(min=2,max=5)
    private String nickName;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(this.email)
                .password(this.password)
                .nickName(this.nickName)
                .build();
    }
}

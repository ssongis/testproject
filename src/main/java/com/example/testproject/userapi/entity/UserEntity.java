package com.example.testproject.userapi.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "usertest")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "system-uuid") // 유일한 ID값을 얻기 위해
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100, unique = true)
    private String password;
    @Column(nullable = false, length = 30)
    private String nickName;
    @Column(length = 30)
    private String birthday;
//    @Column(length = 1000)
//    private String refreshToken;
    @CreationTimestamp
    private LocalDateTime regDate;
}

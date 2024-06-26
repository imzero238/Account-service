package com.ecommerce.accountservice.domain;

import com.ecommerce.accountservice.web.dto.SignUpDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Column(unique = true)
    private String name;

    public static Account fromAccountDto(SignUpDto signUpRequest) {
        return Account.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .name(signUpRequest.getName())
                .build();
    }
}

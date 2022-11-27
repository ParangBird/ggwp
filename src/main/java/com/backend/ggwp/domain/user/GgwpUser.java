package com.backend.ggwp.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class GgwpUser implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;

    @Builder
    public GgwpUser(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        emailAuth = false;
    }
}

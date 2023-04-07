package com.backend.ggwp.domain.bbs.user.user;

import com.backend.ggwp.domain.bbs.post.Post;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GgwpUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;
    private String role;
    private String provider;
    private String providerId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @Builder
    public GgwpUser(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        emailAuth = false;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void setEmailAuth(boolean emailAuth) {
        this.emailAuth = emailAuth;
    }
}

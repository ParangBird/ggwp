package com.backend.ggwp.domain.post;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String content;
    @NotBlank
    private String authorEmail;
    @Enumerated(EnumType.STRING)
    private PostEnum postTag;




/*
    public Post(String title, String author, String content, String authorEmail, PostEnum postTag) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.authorEmail = authorEmail;
        this.postTag = postTag;
    }
*/

}

package com.backend.ggwp.domain.bbs.post;

import com.backend.ggwp.domain.time.BaseTimeEntity;
import com.backend.ggwp.domain.bbs.user.user.GgwpUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
@Builder
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    private GgwpUser user;
    @NotBlank
    private String content;
    @Enumerated(EnumType.STRING)
    private PostEnum postTag;

    public void update(PostDto postDTO) {
        this.title = postDTO.getTitle();
        this.content = postDTO.getContent();
        this.postTag = postDTO.getPostTag();
    }
}

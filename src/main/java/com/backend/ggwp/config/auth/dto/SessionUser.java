package com.backend.ggwp.config.auth.dto;

import com.backend.ggwp.domain.user.PageUser;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    //private String nickname;
    private String picture;

    public SessionUser(PageUser user){
        this.name = user.getName();
        this.email = user.getEmail();
        //this.nickname = user.getNickname();
        this.picture = user.getPicture();
    }
}

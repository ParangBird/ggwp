package com.backend.ggwp.auth;

import com.backend.ggwp.domain.user.PageUser;
import com.backend.ggwp.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class OauthUser implements Serializable, User {
    private String name;
    private String email;
    //private String nickname;
    private String picture;

    public OauthUser(PageUser user){
        this.name = user.getName();
        this.email = user.getEmail();
        //this.nickname = user.getNickname();
        this.picture = user.getPicture();
    }
}

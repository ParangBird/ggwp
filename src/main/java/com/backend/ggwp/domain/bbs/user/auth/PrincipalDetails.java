package com.backend.ggwp.domain.bbs.user.auth;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private GgwpUserDto ggwpUserDto;
    private Map<String, Object> attributes;

    public PrincipalDetails(GgwpUserDto ggwpUserDTO) {
        this.ggwpUserDto = ggwpUserDTO;
    }

    public PrincipalDetails(GgwpUserDto ggwpUserDTO, Map<String, Object> attributes) {
        this.ggwpUserDto = ggwpUserDTO;
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return ggwpUserDto.getName();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
        collect.add(() -> ggwpUserDto.getRole().getRole());
        return collect;
    }

    @Override
    public String getPassword() {
        return ggwpUserDto.getPassword();
    }

    @Override
    public String getUsername() {
        return ggwpUserDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

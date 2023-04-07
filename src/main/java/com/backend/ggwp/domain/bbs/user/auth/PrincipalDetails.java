package com.backend.ggwp.domain.bbs.user.auth;

import com.backend.ggwp.domain.bbs.user.user.GgwpUser;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private final ModelMapper modelMapper;
    private GgwpUser ggwpUser;
    private Map<String, Object> attributes;

    public PrincipalDetails(ModelMapper modelMapper, GgwpUserDTO ggwpUserDTO) {
        this.modelMapper = modelMapper;
        GgwpUser map = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        this.ggwpUser = map;
    }

    public PrincipalDetails(ModelMapper modelMapper, GgwpUserDTO ggwpUserDTO, Map<String, Object> attributes) {
        this.modelMapper = modelMapper;
        this.ggwpUser = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return ggwpUser.getName();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
        collect.add(() -> {
            return ggwpUser.getRole();
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return ggwpUser.getPassword();
    }

    @Override
    public String getUsername() {
        return ggwpUser.getEmail();
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

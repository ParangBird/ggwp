package com.backend.ggwp.domain.bbs.user.auth;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import com.backend.ggwp.domain.bbs.user.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GgwpUserDto byName = userService.findByEmail(username);
        if (byName == null) return null;
        else return new PrincipalDetails(byName);
    }
}

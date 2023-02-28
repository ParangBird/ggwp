package com.backend.ggwp.domain.user;

import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.user.dto.LoginDto;
import com.backend.ggwp.domain.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(GgwpUserDTO ggwpUserDTO) {
        String originPassword = ggwpUserDTO.getPassword();
        ggwpUserDTO.setPassword(passwordEncoder.encode(originPassword));
        GgwpUser ggwpUser = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        GgwpUser save = userRepository.save(ggwpUser);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public GgwpUser login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        GgwpUser user = findByEmail(email).orElseThrow();
        // .matches(평문의 오리지널 패스워드, 암호화된 패스워드)
        if (user.getPassword() == null ||
                !passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        return user;

    }

    @Transactional
    public void registerUser(RegisterDto registerDto){
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        String email = registerDto.getEmail();

        GgwpUserDTO newGgwpUser = GgwpUserDTO.
                builder().
                name(userName).
                password(encodedPassword).
                email(email).
                build();

        save(newGgwpUser);

    }

    public Optional<GgwpUser> findByName(String username) {
        return userRepository.findByName(username);
    }

    public Optional<GgwpUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<GgwpUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

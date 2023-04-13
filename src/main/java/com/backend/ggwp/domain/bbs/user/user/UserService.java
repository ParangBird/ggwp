package com.backend.ggwp.domain.bbs.user.user;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import com.backend.ggwp.domain.bbs.user.dto.LoginDto;
import com.backend.ggwp.domain.bbs.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public static final int NON_DUPLICATED = 0;
    public static final int DUPLICATED_USERNAME = 1;
    public static final int DUPLICATED_EMAIL = 2;

    @Transactional
    public Long save(GgwpUserDto ggwpUserDTO) {
        String originPassword = ggwpUserDTO.getPassword();
        ggwpUserDTO.setPassword(passwordEncoder.encode(originPassword));
        GgwpUser ggwpUser = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        GgwpUser save = userRepository.save(ggwpUser);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public GgwpUserDto login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        GgwpUserDto user = null;
        try {
            user = findByEmail(email);
            log.info("해당 이메일 없음");
        } catch (NoSuchElementException e) {
            return null;
        }
        // .matches(평문의 오리지널 패스워드, 암호화된 패스워드)
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.info("비밀번호 다름");
            return null;
        }
        return user;
    }

    @Transactional
    public Long registerUser(GgwpUserDto ggwpUserDTO) {
        return save(ggwpUserDTO);
    }

    @Transactional
    public Long registerUser(RegisterDto registerDto) {
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String email = registerDto.getEmail();

        GgwpUserDto newGgwpUser = GgwpUserDto
                .builder()
                .name(userName)
                .password(password)
                .email(email)
                .emailAuth(false)
                .role(Role.ROLE_NORMAL_USER)
                .build();

        return save(newGgwpUser);
    }

    @Transactional(readOnly = true)
    public GgwpUserDto findByName(String username) {
        GgwpUser ggwpUser = userRepository.findByName(username).orElseThrow();
        GgwpUserDto dto = modelMapper.map(ggwpUser, GgwpUserDto.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public GgwpUserDto findByEmail(String email) {
        GgwpUser ggwpUser = userRepository.findByEmail(email).orElseThrow();
        GgwpUserDto dto = modelMapper.map(ggwpUser, GgwpUserDto.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public GgwpUserDto findById(Long id) {
        GgwpUser ggwpUser = userRepository.findById(id).orElseThrow();
        GgwpUserDto dto = modelMapper.map(ggwpUser, GgwpUserDto.class);
        return dto;
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            userRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public int checkDuplicateUser(String userName, String email) {

        if (isDuplicatedName(userName)) return DUPLICATED_USERNAME;
        else if (isDuplicatedEmail(email)) return DUPLICATED_EMAIL;
        return NON_DUPLICATED;
    }

    @Transactional(readOnly = true)
    public boolean isDuplicatedName(String username) {
        GgwpUser ggwpUser = userRepository.findByName(username).orElse(null);
        return ggwpUser != null;
    }


    @Transactional(readOnly = true)
    public boolean isDuplicatedEmail(String email) {
        GgwpUser ggwpUser = userRepository.findByEmail(email).orElse(null);
        return ggwpUser != null;
    }

    @Transactional
    public Long deleteByEmail(String email) {
        Long id = userRepository.findByEmail(email).orElseThrow().getId();
        userRepository.deleteById(id);
        return id;
    }
}

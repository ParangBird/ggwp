package com.backend.ggwp.domain.bbs.user;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
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

    @Transactional
    public Long save(GgwpUserDTO ggwpUserDTO) {
        String originPassword = ggwpUserDTO.getPassword();
        ggwpUserDTO.setPassword(passwordEncoder.encode(originPassword));
        GgwpUser ggwpUser = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        GgwpUser save = userRepository.save(ggwpUser);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public GgwpUserDTO login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        GgwpUserDTO user = null;
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
    public Long registerUser(GgwpUserDTO ggwpUserDTO) {
        return save(ggwpUserDTO);
    }

    @Transactional
    public Long registerUser(RegisterDto registerDto) {
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String email = registerDto.getEmail();

        GgwpUserDTO newGgwpUser = GgwpUserDTO.
                builder().
                name(userName).
                password(password).
                email(email).
                build();

        return save(newGgwpUser);
    }

    @Transactional(readOnly = true)
    public GgwpUserDTO findByName(String username) {
        GgwpUser ggwpUser = userRepository.findByName(username).orElseThrow();
        GgwpUserDTO dto = modelMapper.map(ggwpUser, GgwpUserDTO.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public GgwpUserDTO findByEmail(String email) {
        GgwpUser ggwpUser = userRepository.findByEmail(email).orElseThrow();
        GgwpUserDTO dto = modelMapper.map(ggwpUser, GgwpUserDTO.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public GgwpUserDTO findById(Long id) {
        GgwpUser ggwpUser = userRepository.findById(id).orElseThrow();
        GgwpUserDTO dto = modelMapper.map(ggwpUser, GgwpUserDTO.class);
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
        try {
            GgwpUserDTO byName = findByName(userName);
        } catch (Exception e) {
            return 1;
        }
        try {
            GgwpUserDTO byEmail = findByEmail(email);
        } catch (Exception e) {
            return 2;
        }
        return 0;
    }
}

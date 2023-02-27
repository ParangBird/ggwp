package com.backend.ggwp.domain.user;

import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(GgwpUserDTO ggwpUserDTO) {
        GgwpUser ggwpUser = modelMapper.map(ggwpUserDTO, GgwpUser.class);
        GgwpUser save = userRepository.save(ggwpUser);
        return save.getId();
    }

    public Optional<GgwpUser> findByName(String username) {
        return userRepository.findByName(username);
    }

    public Optional<GgwpUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<GgwpUser> findById(Long id){
        return userRepository.findById(id);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

package com.backend.ggwp.domain.bbs.user.oauth;

import com.backend.ggwp.domain.bbs.user.GgwpUser;
import com.backend.ggwp.domain.bbs.user.UserRepository;
import com.backend.ggwp.domain.bbs.user.auth.PrincipalDetails;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.bbs.user.nickname.RandomNicknameService;
import com.backend.ggwp.domain.bbs.user.oauth.provider.GoogleUserInfo;
import com.backend.ggwp.domain.bbs.user.oauth.provider.NaverUserInfo;
import com.backend.ggwp.domain.bbs.user.oauth.provider.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final RandomNicknameService randomNicknameService;
    private final static int NICKNAME_MAX_LENGTH = 8;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // userRequest : accessToken 가진 객체
        // oAuth2User : 해당 token 통해 응답받은 회원정보
        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        // Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            log.info("구글 로그인 요청~~");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            log.info("네이버 로그인 요청~~");
            oAuth2UserInfo = new NaverUserInfo((Map) oAuth2User.getAttributes().get("response"));
        } else {
            throw new IllegalArgumentException("구글, 네이버를 제외한 provider 가 OAuth2 요청으로 들어옴");
        }

        Optional<GgwpUser> userOptional =
                userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());

        GgwpUser user;
        if (userOptional.isPresent()) {
            log.info("있어서 이거 반납");
            user = userOptional.get();
            // user가 존재하면 update 해주기
            user.changeEmail(oAuth2UserInfo.getEmail());
        } else {
            // user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
            log.info("없어서 새로 만들게요");
            user = GgwpUser.builder()
                    .name(randomNicknameService.randomNickname(NICKNAME_MAX_LENGTH))
                    .password(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()))
                    .email(oAuth2UserInfo.getEmail())
                    .role("oauth2_user")
                    .emailAuth(true)
                    .provider(oAuth2UserInfo.getProvider())
                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
        }
        userRepository.save(user);
        GgwpUserDTO map = modelMapper.map(user, GgwpUserDTO.class);
        log.info("OAUTH 반납 객체 : {}", map.toString());
        return new PrincipalDetails(modelMapper, map, oAuth2User.getAttributes());
    }
}

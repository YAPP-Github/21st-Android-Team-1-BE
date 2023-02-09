package yapp.buddycon.web.auth.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.auth.adapter.in.request.KakaoInfoRequestDto;
import yapp.buddycon.web.auth.adapter.in.request.ReissueRequestDto;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberCommandPort;
import yapp.buddycon.web.auth.application.port.out.AuthToMemberQueryPort;
import yapp.buddycon.web.auth.application.port.out.AuthToNotificationSettingCommandPort;
import yapp.buddycon.web.member.domain.Member;
import yapp.buddycon.web.auth.application.port.in.OAuthMemberInfo;
import yapp.buddycon.web.auth.adapter.in.response.TokenResponseDto;
import yapp.buddycon.web.auth.application.port.in.AuthUseCase;
import yapp.buddycon.web.member.domain.NotificationSetting;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

  private final KakaoOAuthMapper kakaoOAuthMapper;
  private final TokenProvider tokenProvider;
  private final TokenDecoder tokenDecoder;
  private final RedisTemplate<String, Object> redisTemplate;
  private final AuthToMemberQueryPort authToMemberQueryPort;
  private final AuthToMemberCommandPort authToMemberCommandPort;
  private final AuthToNotificationSettingCommandPort authToNotificationSettingCommandPort;

  @Transactional
  public TokenResponseDto login(KakaoInfoRequestDto kakaoInfoRequestDto) {
    OAuthMemberInfo oAuthMemberInfo = kakaoOAuthMapper.getUserAttributes(kakaoInfoRequestDto.accessToken());
    Member member = authToMemberQueryPort.findMemberByClientId(oAuthMemberInfo.id());
    if (member == null){
      member = Member.create(oAuthMemberInfo.id(), kakaoInfoRequestDto.email(), kakaoInfoRequestDto.name(), kakaoInfoRequestDto.gender(), kakaoInfoRequestDto.ageRange());
      authToMemberCommandPort.save(member);
      authToNotificationSettingCommandPort.save(NotificationSetting.create(member));
    }
    return tokenProvider.createToken(member.getId());
  }

  @Transactional
  public TokenResponseDto reissue(ReissueRequestDto reissueRequestDto) {
    tokenDecoder.decode(reissueRequestDto.refreshToken()); // to validate refresh token
    Long id = tokenDecoder.decode(reissueRequestDto.accessToken()).getBody().get("memberId", Long.class);
    Object storedRefreshToken = redisTemplate.opsForValue().get("RT:" + id);
    if (storedRefreshToken == null) throw new CustomException(ErrorCode.LOGGED_OUT_MEMBER);
    if (!storedRefreshToken.equals(reissueRequestDto.refreshToken())) throw new CustomException(ErrorCode.TOKEN_MEMBER_INFO_IS_NOT_MATCH);

    return tokenProvider.createToken(id);
  }
}

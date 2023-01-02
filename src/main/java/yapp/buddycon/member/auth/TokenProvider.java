package yapp.buddycon.member.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TokenProvider {
  @Value("${security.jwt.token.bearer-type}")
  private String BEARER_TYPE;
  @Value("${security.jwt.token.secret-key}")
  private String SECRET_KEY;
  @Value("${security.jwt.token.access-token-expire-time}")
  private long ACCESS_TOKEN_EXPIRE_TIME;
  @Value("${security.jwt.token.refresh-token-expire-time}")
  private long REFRESH_TOKEN_EXPIRE_TIME;

  private final RedisTemplate<String, Object> redisTemplate;

  public TokenResponse createToken(Long memberId) {
    String secretKey = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    Date now = new Date();

    Date accessTokenExpiresIn = new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME);
    String accessToken = Jwts.builder()
      .setClaims(new HashMap<String, Long>(){{ put("memberId", memberId); }})
//      .setIssuedAt(now)
      .setExpiration(accessTokenExpiresIn)
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact();
    String refreshToken = Jwts.builder()
      .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME))
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact();

    saveRefreshToken(memberId, refreshToken);

    return new TokenResponse(BEARER_TYPE, accessToken, refreshToken, accessTokenExpiresIn.getTime());
  }

  private void saveRefreshToken(Long memberId, String refreshToken) {
    redisTemplate.opsForValue()
      .set(
        "RT:" + memberId,
        refreshToken,
        REFRESH_TOKEN_EXPIRE_TIME,
        TimeUnit.MILLISECONDS
      );
  }
}

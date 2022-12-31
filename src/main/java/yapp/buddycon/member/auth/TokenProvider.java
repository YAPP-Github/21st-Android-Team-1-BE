package yapp.buddycon.member.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class TokenProvider {
  @Value("${security.jwt.token.bearer-type}")
  private String BEARER_TYPE;
  @Value("${security.jwt.token.secret-key}")
  private String SECRET_KEY;
  @Value("${security.jwt.token.access-token-expire-time}")
  private long ACCESS_TOKEN_EXPIRE_TIME;
  @Value("${security.jwt.token.refresh-token-expire-time}")
  private long REFRESH_TOKEN_EXPIRE_TIME;

  public TokenResponse createToken(String payload) {
    String secretKey = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    Claims claims = Jwts.claims().setSubject(payload);
    Date now = new Date();

    Date accessTokenExpiresIn = new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME);
    String accessToken = Jwts.builder()
      .setClaims(claims)
      .setIssuedAt(now)
      .setExpiration(accessTokenExpiresIn)
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact();
    String refreshToken = Jwts.builder()
      .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME))
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact();

    return new TokenResponse(BEARER_TYPE, accessToken, refreshToken, accessTokenExpiresIn.getTime());
  }
}

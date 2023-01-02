package yapp.buddycon.member.auth;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import yapp.buddycon.exception.CustomException;
import yapp.buddycon.exception.ErrorCode;

@Component
public class TokenDecoder {

  @Value("${security.jwt.token.secret-key}")
  private String SECRET_KEY;

  public Jws<Claims> decode(String token) {
    try {
      return Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
    } catch (ExpiredJwtException e) {
      throw new CustomException(ErrorCode.EXPIRED_ACCESS_TOKEN);
    } catch (SecurityException | MalformedJwtException e) {
      throw new CustomException(ErrorCode.MALFORMED_JWT_TOKEN);
    } catch (UnsupportedJwtException e) {
      throw new CustomException(ErrorCode.UNSUPPORTED_JWT_TOKEN);
    } catch (IllegalArgumentException e) {
      throw new CustomException(ErrorCode.INVALID_JWT_TOKEN);
    }
  }
}

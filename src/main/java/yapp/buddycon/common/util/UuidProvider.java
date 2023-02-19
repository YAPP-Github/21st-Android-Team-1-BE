package yapp.buddycon.common.util;

import java.util.UUID;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UuidProvider {

  public static String generateUuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
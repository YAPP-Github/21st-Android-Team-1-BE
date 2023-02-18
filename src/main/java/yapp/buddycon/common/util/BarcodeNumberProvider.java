package yapp.buddycon.common.util;

import java.util.Random;
import org.springframework.stereotype.Component;
import yapp.buddycon.web.coupon.application.port.out.CouponToBarcodeNumberProviderPort;

@Component
public class BarcodeNumberProvider implements CouponToBarcodeNumberProviderPort {

  @Override
  public String createRandomBarcodeNumber() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 57; // letter '9'
    int[] lengthList = {4, 4, 7};

    Random random = new Random();
    String generatedString = "";

    for (int length : lengthList) {
      generatedString += random.ints(leftLimit, rightLimit + 1)
          .limit(length)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
      generatedString += "-";
    }
    return generatedString.substring(0, generatedString.length() - 1);
  }

}

package yapp.buddycon.web.coupon.application.port.out;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface CouponToAwsS3Port {

  String upload(MultipartFile file) throws IOException;

}

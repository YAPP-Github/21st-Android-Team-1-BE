package yapp.buddycon.web.coupon.application.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface CouponToAwsS3Port {

  String upload(MultipartFile file);

}

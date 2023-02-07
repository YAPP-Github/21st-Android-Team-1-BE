package yapp.buddycon.common.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.common.exception.CustomException;
import yapp.buddycon.common.exception.ErrorCode;
import yapp.buddycon.web.coupon.application.port.out.CouponToAwsS3Port;

@Slf4j
@RequiredArgsConstructor
@Component
public class AwsS3FileProvider implements CouponToAwsS3Port {

  private final AmazonS3 s3Client;

  @Value("${cloud.s3.bucket}")
  private String BUCKET_NAME;
  @Value("${cloud.s3.path.root}")
  private String PATH_ROOT;
  @Value("${cloud.s3.path.url}")
  private String PATH_URL;

  @Override
  public String upload(MultipartFile file) {
    String s3PathKey = PATH_ROOT + "/" + UuidProvider.generateUuid();
    ObjectMetadata metaData = new ObjectMetadata();
    metaData.setContentLength(file.getSize());
    metaData.setContentType(file.getContentType());
    try {
      PutObjectResult result = s3Client
          .putObject(new PutObjectRequest(BUCKET_NAME, s3PathKey, file.getInputStream(), metaData));
    } catch (IOException e) {
      log.error("AwsS3FileProvider throw IOException : {}", e);
      throw new CustomException(ErrorCode.FAILED_TO_UPLOAD_IMAGE);
    }
    return PATH_URL + "/" + s3PathKey;
  }

}

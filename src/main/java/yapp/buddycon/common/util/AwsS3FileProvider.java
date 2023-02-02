package yapp.buddycon.common.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import yapp.buddycon.web.coupon.application.port.out.CouponToAwsS3Port;

@RequiredArgsConstructor
@Component
public class AwsS3FileProvider implements CouponToAwsS3Port {

  private final AmazonS3 s3Client;

  @Value("${cloud.s3.bucket}")
  private String BUCKET_NAME;
  @Value("${cloud.s3.path.root}")
  private String PATH_ROOT;

  @Override
  public String upload(MultipartFile file) throws IOException {
    String s3PathKey = PATH_ROOT + "/" + UuidProvider.generateUuid();
    ObjectMetadata metaData = new ObjectMetadata();
    metaData.setContentLength(file.getSize());
    metaData.setContentType(file.getContentType());
    PutObjectResult result = s3Client
        .putObject(new PutObjectRequest(BUCKET_NAME, s3PathKey, file.getInputStream(), metaData));
    return s3PathKey;
  }

}

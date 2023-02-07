package yapp.buddycon.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3Config {

  @Value("${cloud.aws.credentials.accessKey}")
  private String ACCESS_KEY;
  @Value("${cloud.aws.credentials.secretKey}")
  private String SECRET_KEY;
  @Value("${cloud.aws.region}")
  private String REGION;

  @Bean
  public AWSCredentials awsCredentials() {
    return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
  }

  @Bean
  public AmazonS3 amazonS3Client(AWSCredentials awsCredentials) {
    return AmazonS3ClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .withRegion(REGION)
        .build();
  }

}
package com.kh.works;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Value("${aws.s3.region2}")
    private String region2;

    @Value("${aws.s3.accessToken2}")
    private String accessToken2;

    @Value("${aws.s3.secretKey2}")
    private  String secretKey2;

    @Bean
    public AmazonS3 m01(){
        //BasicAWSCredentials 인증에 필요한거
        BasicAWSCredentials credentials=new BasicAWSCredentials(accessToken2,secretKey2);
        AWSStaticCredentialsProvider provider=new AWSStaticCredentialsProvider(credentials);

        // AmazonS3Client s3Client=new AmazonS3Client();
        return   AmazonS3ClientBuilder
                .standard()
                .withRegion(region2)
                .withCredentials(provider)
                .build();
    }
}

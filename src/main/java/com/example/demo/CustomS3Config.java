package com.example.demo;

import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class CustomS3Config {

	@Bean
	public S3Client s3Client() throws URISyntaxException 
	{
		System.out.println("S3 client Bean");
		return S3Client.builder().build();
	}
}

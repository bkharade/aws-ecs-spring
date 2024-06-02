package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/demo")
public class controller {

	@Autowired
	S3Client s3Client ;
	
	@GetMapping("Spring")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("iAmLive")
	public String iamAlive() {
		return "Installed at June 1st,2024";
	}

	@GetMapping("ListBucket")
	public List<String> getS3Objects(@RequestParam String bucketName)
	{
		System.out.println("Entering listobjects");
		
		ListObjectsRequest listObjects = ListObjectsRequest.builder().bucket(bucketName).build();
		
		ListObjectsResponse res =s3Client.listObjects(listObjects);
		
		List<S3Object> objects = res.contents();
		
		List<String> keys = objects.stream().map(S3Object::key).collect(Collectors.toList());
		
		for(S3Object myValue : objects) 
		{
			System.out.println("The name of the key is ::" +myValue.key());
		}
		
		return keys;
		
	}
}
package com.example.TT.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface MinioService {

    void createBucket(String bucketName) throws Exception;

    void uploadFile(String bucketName, MultipartFile file) throws Exception;

    InputStream downloadFile(String bucketName, String fileName) throws Exception;
}

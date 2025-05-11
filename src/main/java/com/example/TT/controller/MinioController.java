package com.example.TT.controller;

import com.example.TT.service.MinioService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/minio")
@RequiredArgsConstructor
public class MinioController {

    private final MinioService minioService;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile file,
                             @RequestHeader("bucketName") String bucketName) {
        try {
            minioService.uploadFile(bucketName, file);
            return "Файл успешно загружен!";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable String fileName, @RequestHeader("bucketName") String bucketName, HttpServletResponse response) {
        try {
            InputStream fileStream = minioService.downloadFile(bucketName, fileName);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            IOUtils.copy(fileStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

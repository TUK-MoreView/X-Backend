package com.moreview.global.s3.controller;

import com.moreview.global.s3.service.S3FileUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image/upload")
public class S3FileUploaderController {

    private final S3FileUploader s3FileUploader;

    @PostMapping
    @ResponseBody
    public Map<String, Object> imageUpload(MultipartRequest request) throws IOException{

        Map<String, Object> responseData = new HashMap<>();

        try {

            String s3Url = s3FileUploader.imageUpload(request);

            responseData.put("uploaded", true);
            responseData.put("url", s3Url);

            return responseData;

        } catch (IOException e) {

            responseData.put("uploaded", false);

            return responseData;
        }
        }
}

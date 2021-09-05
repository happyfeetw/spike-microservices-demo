package com.spike.demoservicea.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * date: 2021/9/5
 * author: Spike
 * description:
 */
@RestController
public class DemoFileController {

    @PostMapping("/demo/upload")
    public void fileUpload(@RequestParam("file") MultipartFile multipartFile) {

        System.out.println("multipartFile.getOriginalFilename() = " + multipartFile.getOriginalFilename());
        System.out.println("multipartFile.getName() = " + multipartFile.getName());
        String name = FilenameUtils.getName(multipartFile.getOriginalFilename());
        System.out.println("name = " + name);

    }
}

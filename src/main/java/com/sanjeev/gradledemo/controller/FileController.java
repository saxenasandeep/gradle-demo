/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Source FileController.java created on Feb 10, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@RestController
@RequestMapping(value = "/cms/v1")
public class FileController {

    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") String id) throws IOException {

        Path path = Paths.get(new ClassPathResource("files-attachments/resume.pdf").getFile().getAbsolutePath());

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf")
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
    }

}

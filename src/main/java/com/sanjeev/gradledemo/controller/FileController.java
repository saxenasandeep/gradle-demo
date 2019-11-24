/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sanjeev.gradledemo.dto.FileDto;

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

    private final Logger log = LoggerFactory.getLogger(FileController.class);
    private final String location = "D:\\git-repo\\";

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") String id) throws IOException {

        final Path path = Paths.get(new ClassPathResource("files-attachments/resume.pdf").getFile().getAbsolutePath());

        final ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf")
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
    }

    /**
     *
     * @param fileDto
     * @return
     * @throws IOException
     */
    @PostMapping("/file")
    public ResponseEntity<?> upload(@ModelAttribute FileDto fileDto) throws IOException {

        if (fileDto.getFiles().length == 0) {
            return new ResponseEntity<>("No file to upload", HttpStatus.OK);
        }

        for (final MultipartFile file : fileDto.getFiles()) {
            final Path path = Paths.get(location + file.getOriginalFilename());
            log.info("Writing file {} to location {}, contentType : {}", file.getOriginalFilename(), location,
                    file.getContentType());

            Files.write(path, file.getBytes(), StandardOpenOption.CREATE);
        }
        return new ResponseEntity<>("File upload completed", HttpStatus.OK);
    }

}

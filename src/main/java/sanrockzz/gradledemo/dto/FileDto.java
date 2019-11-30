/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package sanrockzz.gradledemo.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Source FileDto.java created on Feb 11, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class FileDto {

    private String description;
    private MultipartFile[] files;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the files
     */
    public MultipartFile[] getFiles() {
        return files;
    }

    /**
     * @param files
     *            the files to set
     */
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}

/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */
package com.sanjeev.spring.boot.exception;

/**
 * 
 * @author : Sanjeev Saxena
 * @Date : Oct 29, 2017
 * @since : 1.0
 */

public class ContactServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String            message;

    /**
     * 
     */
    public ContactServiceException(String message) {
        this.message = message;
    }

}

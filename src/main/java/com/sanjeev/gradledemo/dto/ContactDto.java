/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */
package com.sanjeev.gradledemo.dto;

import org.json.JSONObject;

/**
 * Contact DTO
 * 
 * @author : Sanjeev Saxena
 * @date : Oct 29, 2017
 * @since : 1.0
 */

public class ContactDto {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    public String toString(int indentFactor) {
        return new JSONObject(this).toString(indentFactor);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

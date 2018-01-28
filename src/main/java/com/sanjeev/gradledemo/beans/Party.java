/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.beans;

import java.time.LocalDate;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;

/**
 * Source Party.java created on Jan 20, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class Party {

    @Id
    String partyId;
    String firstName;
    String lastName;
    LocalDate dob;

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

    public String toString(int indentFactor) {
        return new JSONObject(this).toString(indentFactor);
    }

    /**
     * @return the partyId
     */
    public String getPartyId() {
        return partyId;
    }

    /**
     * @param partyId
     *            the partyId to set
     */
    public void setPartyId(String partyId) {
        this.partyId = partyId;
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

    /**
     * @return the dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}

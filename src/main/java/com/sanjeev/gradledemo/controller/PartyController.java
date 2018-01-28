/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.gradledemo.beans.Party;
import com.sanjeev.gradledemo.service.EntityServices;

/**
 * Source PartyController.java created on Jan 26, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@RestController
@RequestMapping(value = "/cms/v1", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PartyController {

    private final Logger log = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private EntityServices<Party> iEntity;

    @PostMapping("/party")
    public ResponseEntity<Party> createParty(Party party) {

        log.info("Request received for party creation : {}", party);
        Party entity = iEntity.createEntity(party);
        log.info("Party created. Response : {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

}

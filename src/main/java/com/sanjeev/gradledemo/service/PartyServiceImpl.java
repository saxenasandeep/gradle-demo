/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.sanjeev.gradledemo.beans.Party;

/**
 * Source EntityServiceImpl.java created on Jan 26, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Component
public class PartyServiceImpl implements EntityServices<Party> {

    private MongoRepository<Party, String> mangoRepo;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sanjeev.gradledemo.service.IEntity#createEntity(java.lang.Object)
     */
    @Override
    public Party createEntity(Party party) {

        party = mangoRepo.save(party);
        return party;
    }

}

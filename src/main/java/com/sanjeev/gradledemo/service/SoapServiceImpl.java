/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.ms.nao.csid.model.Add;
import com.ms.nao.csid.model.AddResponse;
import com.ms.nao.csid.model.ICalculator;
import com.ms.nao.csid.model.ObjectFactory;

/**
 * Source SoapServiceImpl.java created on Sep 9, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Configuration
public class SoapServiceImpl implements ICalculator {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see com.ms.nao.csid.model.ICalculator#subtract(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public Integer subtract(Integer a, Integer b) {

        ObjectFactory factory = new ObjectFactory();
        Add add = factory.createAdd();

        add.setA(a);
        add.setB(b);

        AddResponse addResponse = factory.createAddResponse();

        addResponse = (AddResponse) webServiceTemplate.marshalSendAndReceive(add);

        log.info("Result :{}", addResponse.getResult());

        return addResponse.getResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ms.nao.csid.model.ICalculator#add(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public Integer add(Integer a, Integer b) {
        // TODO Auto-generated method stub
        return null;
    }
}

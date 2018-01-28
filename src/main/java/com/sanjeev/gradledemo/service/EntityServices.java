/**
 * f * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.gradledemo.service;

/**
 * Source EntityServices.java created on Jan 26, 2018
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface EntityServices<T> {

    /**
     * 
     * @param entity
     * @return
     */
    public T createEntity(T entity);

}

/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.help;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public abstract class BusinessObject<T extends Identifiable<ID>, ID, R extends JpaRepository<T, ID>> implements Serializable
{
    protected T entity;

    @Autowired
    private R repository;


    public BusinessObject(T entity)
    {
        this.entity = entity;
    }


    protected T attached()
    {
        return repository.getOne(entity.getId());
    }


    public ID getId()
    {
        return attached().getId();
    }
}

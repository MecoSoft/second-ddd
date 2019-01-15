/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.help;


import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
public abstract class EntityBase<P extends Serializable, M>
{
    @Id
    @GeneratedValue
    protected P id;

    @Embedded
    protected M model;


    protected P getId()
    {
        return id;
    }


    public M getModel()
    {
        return model;
    }


    public void setModel(M model)
    {
        this.model = model;
    }
}

package com.skxj.firstboot.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Snow on 7/11/2017.
 */
public class User implements Serializable {

    private String name;
    private String sex;
    private Integer id;
    private Date birs;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirs() {
        return birs;
    }

    public void setBirs(Date birs) {
        this.birs = birs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

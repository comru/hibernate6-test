package com.test.model;

import java.io.Serializable;
import java.util.Date;

public class PojoClass implements Serializable {
    private String data;
    private Integer integerAttr;
    private Date localDateTime;

    public PojoClass() {
    }

    public PojoClass(String data, Integer integerAttr, Date localDateTime) {
        this.data = data;
        this.integerAttr = integerAttr;
        this.localDateTime = localDateTime;
    }

    public String getData() {
        return data;
    }

    public PojoClass setData(String data) {
        this.data = data;
        return this;
    }

    public Integer getIntegerAttr() {
        return integerAttr;
    }

    public PojoClass setIntegerAttr(Integer integerAttr) {
        this.integerAttr = integerAttr;
        return this;
    }

    public Date getLocalDateTime() {
        return localDateTime;
    }

    public PojoClass setLocalDateTime(Date localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    @Override
    public String toString() {
        return "PojoClass{" +
                "data='" + data + '\'' +
                ", integerAttr=" + integerAttr +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

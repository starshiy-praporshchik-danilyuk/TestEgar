package com.example.project_test.domain;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
public class InformPK implements Serializable {

    static final long serialVersionUTD = 1L;

    private Date date;
    private String name;

    public InformPK() {}

    public InformPK(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}

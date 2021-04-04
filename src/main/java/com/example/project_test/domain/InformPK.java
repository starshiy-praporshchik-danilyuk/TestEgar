package com.example.project_test.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@EqualsAndHashCode
@ToString
public class InformPK implements Serializable {
    static final long serialVersionUTD = 1L;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String name;

    public InformPK() {

    }
    public InformPK(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}

package com.example.project_test.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;

@Entity
@IdClass(InformPK.class)
@Data

public class Inform {
    @Id
    @Getter
    @Setter

    private Date date;

    @Id
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int price;

    public Inform(){}

    public Inform(Date date, String name, int price) {
        this.date = date;
        this.name = name;
        this.price = price;
    }
}

package com.example.project_test.controller;

import lombok.Data;
import java.sql.Date;

@Data
public class Struct {

    private Date newDate;
    private String newName;
    private int newPrice;
    private Date oldDate;
    private String oldName;

    public Struct() {
    }
}

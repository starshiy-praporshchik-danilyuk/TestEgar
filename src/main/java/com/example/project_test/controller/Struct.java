package com.example.project_test.controller;

import com.example.project_test.domain.Inform;
import com.example.project_test.domain.InformPK;

import java.sql.Date;

public class Struct {
    private Date newDate;
    private String newName;
    private int newPrice;
    private Date oldDate;
    private String oldName;

    public Struct() {
    }

    public Struct(Date newDate, String newName, Integer newPrice, Date oldDate, String oldName) {
        this.newDate = newDate;
        this.newName = newName;
        this.newPrice = newPrice;
        this.oldDate = oldDate;
        this.oldName = oldName;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}

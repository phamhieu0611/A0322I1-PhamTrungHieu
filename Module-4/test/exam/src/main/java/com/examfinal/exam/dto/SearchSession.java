package com.examfinal.exam.dto;

import java.util.Date;

public class SearchSession {

    private Date value;
    private Date value2;

    public SearchSession() {
    }

    public SearchSession(Date value, Date value2) {
        this.value = value;
        this.value2 = value2;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public Date getValue2() {
        return value2;
    }

    public void setValue2(Date value2) {
        this.value2 = value2;
    }
}

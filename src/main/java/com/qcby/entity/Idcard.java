package com.qcby.entity;

public class Idcard {
    private Integer id;
    private String idcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Idcard{" +
                "id=" + id +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}

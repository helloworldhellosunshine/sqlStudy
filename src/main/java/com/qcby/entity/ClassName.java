package com.qcby.entity;

import java.util.List;

public class ClassName {
    private Integer id;
    private String className;

    /**
     * 关联表
     */
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", users=" + users +
                '}';
    }
}

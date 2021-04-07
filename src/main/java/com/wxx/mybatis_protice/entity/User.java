package com.wxx.mybatis_protice.entity;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;

    private List<Order> orderList;

    private List<Role> roleList;

    public User() {
    }

    public User(int id, String username, String password, List<Order> orderList, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.orderList = orderList;
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                '}';
    }
}

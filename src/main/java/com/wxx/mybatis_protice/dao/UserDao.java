package com.wxx.mybatis_protice.dao;

import com.wxx.mybatis_protice.entity.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);

    int delUser(int id);

    int updateUser(User user);

    List<User> getUserList();

    User getUser(User user);

    List<User> getUserById(int[] ids);

    List<User> getUserInfo();
}

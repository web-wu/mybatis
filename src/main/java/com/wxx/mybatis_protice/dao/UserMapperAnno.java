package com.wxx.mybatis_protice.dao;

import com.wxx.mybatis_protice.entity.Order;
import com.wxx.mybatis_protice.entity.Role;
import com.wxx.mybatis_protice.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapperAnno {

    @Insert("insert into user values(#{id}, #{username}, #{password})")
    void addUser(User user);

    @Delete("delete from user where id = #{id}")
    void delUser(int id);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    void updateUser(User user);

    @Select("select * from user where id = #{id}")
    User findOne(int id);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid", javaType = User.class,
                    one = @One(select = "com.wxx.mybatis_protice.dao.UserMapperAnno.findOne")
            )
    })
    List<Order> orderInfo();

    @Select("select * from orders where uid = #{id}")
    List<Order> orderList(int id);

    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "orderList", column = "id", javaType = List.class,
                    many =  @Many(select = "com.wxx.mybatis_protice.dao.UserMapperAnno.orderList")
            ),
    })
    List<User> userAndOrder();

    @Select("select * from sys_role r join sys_user_role ur on ur.roleId = r.id and ur.userId = #{id}")
    List<Role> roleList(int id);

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.wxx.mybatis_protice.dao.UserMapperAnno.roleList")
            ),
            @Result(property = "orderList", column = "id", javaType = List.class,
                    many =  @Many(select = "com.wxx.mybatis_protice.dao.UserMapperAnno.orderList")
            )
    })
    List<User> userAndRole();
}

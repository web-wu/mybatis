package com.wxx.mybatis_protice.dao;

import com.wxx.mybatis_protice.entity.Order;

import java.util.List;

public interface OrderMapper {
    int addOrder(Order order);

    List<Order> getOrderList();

}

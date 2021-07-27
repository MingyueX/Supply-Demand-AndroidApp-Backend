package org.practice.service;

import org.practice.model.OrderForm;

import java.util.List;

public interface OrderFormService {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderForm orderForm);

    OrderForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(OrderForm orderForm);

    int getCounts(int uid);

    List<OrderForm> selectByUid(int uid, int start);
}

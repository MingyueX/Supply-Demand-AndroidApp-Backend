package org.practice.service.impl;

import org.practice.dao.OrderFormDao;
import org.practice.model.OrderForm;
import org.practice.service.OrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Resource
    private OrderFormDao orderFormDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(OrderForm orderForm) {
        return orderFormDao.insert(orderForm);
    }

    @Override
    public OrderForm selectByPrimaryKey(Integer id) {
        return orderFormDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(OrderForm orderForm) {
        return orderFormDao.updateByPrimaryKey(orderForm);
    }

    @Override
    public int getCounts(int uid) {
        return orderFormDao.getCounts(uid);
    }

    @Override
    public List<OrderForm> selectByUid(int uid, int start) {
        return orderFormDao.selectByUid(uid,start);
    }
}

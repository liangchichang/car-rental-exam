package me.lcc.carrent.service.impl;

import me.lcc.carrent.dao.CarRentDao;
import me.lcc.carrent.dao.OrderDao;
import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.OrderInfo;
import me.lcc.carrent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CarRentDao carRentDao;

    @Override
    public List<OrderInfo> listUserOrders(String userId) {
        return orderDao.listByUserId(userId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BusinessBo cancelOrder(String userId, Integer orderId) {
        OrderInfo orderInfo = orderDao.getById(orderId);
        carRentDao.increaseCarStock(orderInfo.getCarId());
        orderDao.cancel(orderId, userId);
        return BusinessBo.createSuccess();
    }
}

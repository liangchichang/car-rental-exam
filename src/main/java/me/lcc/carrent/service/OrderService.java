package me.lcc.carrent.service;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.OrderInfo;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/30
 */
public interface OrderService {

    List<OrderInfo> listUserOrders(String userId);

    BusinessBo cancelOrder(String userId, Integer orderId);
}

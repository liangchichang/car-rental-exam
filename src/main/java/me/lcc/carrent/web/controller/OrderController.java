package me.lcc.carrent.web.controller;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.OrderInfo;
import me.lcc.carrent.service.OrderService;
import me.lcc.carrent.web.LogInContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * query orders of a user
     */
    @GetMapping("/list")
    public ModelAndView listOrders() {
        String userId = LogInContext.getUserId();
        List<OrderInfo> orderInfos = orderService.listUserOrders(userId);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders.html");
        mv.addObject("orders", orderInfos);
        return mv;
    }

    /**
     * cancel the order
     */
    @PostMapping("/cancel")
    public ModelAndView cancelOrder(Integer orderId) {
        String userId = LogInContext.getUserId();
        BusinessBo businessBo = orderService.cancelOrder(userId, orderId);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.html");
        mv.addObject("message", businessBo.getMessage());
        return mv;
    }
}

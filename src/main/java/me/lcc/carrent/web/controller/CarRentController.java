package me.lcc.carrent.web.controller;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.CarStockInfo;
import me.lcc.carrent.service.CarRentService;
import me.lcc.carrent.web.LogInContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/30
 */
@RestController
@RequestMapping("/carRent")
public class CarRentController {

    @Autowired
    private CarRentService carRentService;

    /**
     * query car and stock information to show
     */
    @RequestMapping("/rentPage")
    public ModelAndView mainPage() {
        List<CarStockInfo> carStockInfos = carRentService.listCarStocks();

        ModelAndView mv = new ModelAndView();
        mv.addObject("carStockInfos", carStockInfos);
        mv.addObject("userId", LogInContext.getUserId());
        mv.setViewName("main.html");
        return mv;
    }

    /**
     * user do rent a car
     */
    @PostMapping("/doRent")
    public ModelAndView rentCar(String userId, Integer carId) {
        BusinessBo businessBo = carRentService.rentACar(userId, carId);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.html");
        mv.addObject("message", businessBo.getMessage());
        return mv;
    }
}

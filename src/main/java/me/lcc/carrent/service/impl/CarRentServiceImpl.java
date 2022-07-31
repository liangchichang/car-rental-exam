package me.lcc.carrent.service.impl;

import me.lcc.carrent.dao.CarRentDao;
import me.lcc.carrent.dao.OrderDao;
import me.lcc.carrent.domain.BusinessCodeEnum;
import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.CarStockInfo;
import me.lcc.carrent.service.CarRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Service
public class CarRentServiceImpl implements CarRentService {

    @Autowired
    private CarRentDao carRentDao;
    @Autowired
    private OrderDao orderDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BusinessBo rentACar(String userId, Integer carId) {
        int count = carRentDao.deductCarStock(carId);
        if (count <= 0) {
            //失败逻辑
            return BusinessBo.createFail(BusinessCodeEnum.CAR_STOCK_NOT_ENOUGH);
        }
        CarStockInfo carInfo = carRentDao.getById(carId);
        orderDao.create(userId, carId, carInfo.getCarModel());
        return BusinessBo.createSuccess();
    }

    @Override
    public List<CarStockInfo> listCarStocks() {
        return carRentDao.listCarInfos();
    }
}

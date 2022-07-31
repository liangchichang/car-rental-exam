package me.lcc.carrent.service;

import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.CarStockInfo;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/30
 */
public interface CarRentService {

    BusinessBo rentACar(String userId, Integer carId);

    List<CarStockInfo> listCarStocks();
}

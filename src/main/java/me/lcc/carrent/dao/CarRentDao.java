package me.lcc.carrent.dao;

import me.lcc.carrent.domain.model.CarStockInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/31
 */
@Mapper
public interface CarRentDao {

    @Select("SELECT id,car_model as carModel, stock FROM car_info")
    List<CarStockInfo> listCarInfos();

    @Update("UPDATE car_info SET stock = stock - 1, update_time = NOW() WHERE id = #{carId} AND stock > 0")
    int deductCarStock(Integer carId);

    @Update("UPDATE car_info SET stock = stock + 1, update_time = NOW() WHERE id = #{carId}")
    int increaseCarStock(Integer carId);

    @Select("SELECT id,car_model as carModel, stock FROM car_info WHERE id = #{carId}")
    CarStockInfo getById(Integer carId);
}

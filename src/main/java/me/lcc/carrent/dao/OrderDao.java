package me.lcc.carrent.dao;

import me.lcc.carrent.domain.model.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lcc
 * @version 2022/7/31
 */
@Mapper
public interface OrderDao {

    @Insert("insert into order_info(user_id,car_id,car_model,`status`,create_time,update_time) " +
            "VALUES(#{userId}, #{carId}, #{carModel} ,0,NOW(),NOW())")
    void create(String userId, Integer carId, String carModel);

    @Update("update order_info set `status` = 1 where id = #{orderId} and user_id = #{userId}")
    int cancel(Integer orderId, String userId);

    @Select("select id,user_id as userId,car_id as carId,car_model as carModel,status,create_time as createTime,update_time as updateTime from order_info where user_id = #{userId}")
    List<OrderInfo> listByUserId(String userId);

    @Select("select id,user_id as userId,car_id as carId,car_model as carModel,status,create_time as createTime,update_time as updateTime from order_info where id = #{orderId}")
    OrderInfo getById(Integer orderId);
}

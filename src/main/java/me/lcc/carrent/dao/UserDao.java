package me.lcc.carrent.dao;


import me.lcc.carrent.domain.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Mapper
public interface UserDao {

    @Insert("insert into user_info(userId, password) values(#{userId},#{password})")
    void register(UserInfo user);

    @Select(value = "select id,userId,password from user_info where userId=#{userId}")
    UserInfo queryById(String userId);
}

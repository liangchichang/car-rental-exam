package me.lcc.carrent.service;

import me.lcc.carrent.domain.bo.BusinessBo;

/**
 * @author lcc
 * @version 2022/7/30
 */
public interface UserService {

    /**
     * 注册账号
     */
    BusinessBo register(String userId, String password);

    /**
     * 登陆
     */
    BusinessBo logIn(String userId, String password);
}

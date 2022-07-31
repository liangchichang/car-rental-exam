package me.lcc.carrent.service.impl;

import me.lcc.carrent.dao.UserDao;
import me.lcc.carrent.domain.BusinessCodeEnum;
import me.lcc.carrent.domain.bo.BusinessBo;
import me.lcc.carrent.domain.model.UserInfo;
import me.lcc.carrent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lcc
 * @version 2022/7/30
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public BusinessBo register(String userId, String password) {
        UserInfo newUser = new UserInfo();
        newUser.setUserId(userId);
        newUser.setPassword(password);
        try {
            userDao.register(newUser);
        } catch (Exception e) {
            LOGGER.error("register encount some problem", e);
            return BusinessBo.createFail(BusinessCodeEnum.USER_CREATE_FAILED);
        }
        return BusinessBo.createSuccess();
    }

    @Override
    public BusinessBo logIn(String userId, String password) {
        UserInfo userInfo = userDao.queryById(userId);
        if (userInfo == null) {
            return BusinessBo.createFail(BusinessCodeEnum.USER_NOT_EXIST);
        }
        if (!password.equals(userInfo.getPassword())) {
            return BusinessBo.createFail(BusinessCodeEnum.USER_AUTH_FAILED);
        }
        return BusinessBo.createSuccess();
    }
}

package me.lcc.carrent.domain.bo;

import me.lcc.carrent.domain.BusinessCodeEnum;

/**
 * @author lcc
 * @version 2022/7/30
 */
public class BusinessBo {

    private boolean isSuccess;
    private String code;
    private String message;

    public static BusinessBo createSuccess() {
        BusinessBo bo = new BusinessBo();
        bo.setCode(BusinessCodeEnum.SUCCESS.getCode());
        bo.setSuccess(true);
        bo.setMessage(BusinessCodeEnum.SUCCESS.getDesc());
        return bo;
    }

    public static BusinessBo createFail(BusinessCodeEnum businessCodeEnum) {
        BusinessBo bo = new BusinessBo();
        bo.setCode(businessCodeEnum.getCode());
        bo.setSuccess(false);
        bo.setMessage(businessCodeEnum.getDesc());
        return bo;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

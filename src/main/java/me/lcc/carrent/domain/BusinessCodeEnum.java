package me.lcc.carrent.domain;

/**
 * @author lcc
 * @version 2022/7/30
 */
public enum BusinessCodeEnum {

    SUCCESS("0", "success"),
    USER_NOT_EXIST("8001", "user not exist"),
    USER_AUTH_FAILED("8002", "user auth failed"),
    USER_CREATE_FAILED("8003", "user creating has failed"),

    CAR_STOCK_NOT_ENOUGH("9001", "car stock not enough");


    private final String code;
    private final String desc;

    BusinessCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }
}

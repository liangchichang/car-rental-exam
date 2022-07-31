package me.lcc.carrent.domain.model;

import java.time.LocalDateTime;

/**
 * @author lcc
 * @version 2022/7/30
 */
public class OrderInfo {

    /**
     * status for an order create success
     */
    public static final int STATUS_ORDERED = 0;
    /**
     * status for an order has been cancel by the company or customer
     */
    public static final int STATUS_CANCEL = 1;

    private Integer id;
    private String userId;
    private Integer carId;
    private String carModel;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}

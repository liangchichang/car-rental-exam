package me.lcc.carrent.domain.model;

/**
 * @author lcc
 * @version 2022/7/30
 */
public class CarStockInfo {

    private Integer id;
    private String carModel;
    private Integer stock;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

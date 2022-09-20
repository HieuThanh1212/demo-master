package com.vmo.springboot.Demo.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class WaterBillRequestDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "create_at")
    private Date createAt;

    @JsonProperty(value = "update_at")
    private Date updateAt;

    @JsonProperty(value = "water_number_old")
    private int waterNumberOld;

    @JsonProperty(value = "water_number_new")
    private int waterNumberNew;

    private int unit;

    private int status;

    public WaterBillRequestDto(String name, int waterNumberOld, int waterNumberNew, int unit, int status) {
        this.name = name;
        this.waterNumberOld = waterNumberOld;
        this.waterNumberNew = waterNumberNew;
        this.unit = unit;
        this.status = status;
    }

    public WaterBillRequestDto() {
    }

    public WaterBillRequestDto(int waterNumberNew, int unit) {
        this.waterNumberNew = waterNumberNew;
        this.unit = unit;
    }

    public WaterBillRequestDto(String name, Date createAt, Date updateAt, int waterNumberOld, int waterNumberNew, int unit, int status) {
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.waterNumberOld = waterNumberOld;
        this.waterNumberNew = waterNumberNew;
        this.unit = unit;
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getWaterNumberOld() {
        return waterNumberOld;
    }

    public void setWaterNumberOld(int waterNumberOld) {
        this.waterNumberOld = waterNumberOld;
    }

    public int getWaterNumberNew() {
        return waterNumberNew;
    }

    public void setWaterNumberNew(int waterNumberNew) {
        this.waterNumberNew = waterNumberNew;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

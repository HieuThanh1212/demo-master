package com.vmo.springboot.Demo.dto.Respone;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class ElectricBillResponseDto {
    private Integer id;

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

    @JsonProperty(value = "electric_number_old")
    private int electricNumberOld;

    @JsonProperty(value = "electric_number_new")
    private int electricNumberNew;

    private int unit;

    private int status;

    private String total;

    public ElectricBillResponseDto(Integer id, String name, Date createAt, Date updateAt, int electricNumberOld, int electricNumberNew, int unit, int status, String total) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.electricNumberOld = electricNumberOld;
        this.electricNumberNew = electricNumberNew;
        this.unit = unit;
        this.status = status;
        this.total = total;
    }

    public ElectricBillResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getElectricNumberOld() {
        return electricNumberOld;
    }

    public void setElectricNumberOld(int electricNumberOld) {
        this.electricNumberOld = electricNumberOld;
    }

    public int getElectricNumberNew() {
        return electricNumberNew;
    }

    public void setElectricNumberNew(int electricNumberNew) {
        this.electricNumberNew = electricNumberNew;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

package com.vmo.springboot.Demo.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class ElectricBillRequestDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "createE")
    private Date createAt;

    @JsonProperty(value = "updateE")
    private Date updateAt;

    @JsonProperty(value = "oldBillE")
    private int electricNumberOld;

    @JsonProperty(value = "newBillE")
    private int electricNumberNew;

    private int unit;

    private int status;

    public ElectricBillRequestDto(String name, Date createAt, Date updateAt, int electricNumberOld, int electricNumberNew, int unit, int status) {
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.electricNumberOld = electricNumberOld;
        this.electricNumberNew = electricNumberNew;
        this.unit = unit;
        this.status = status;
    }

    public ElectricBillRequestDto(int electricNumberNew, int unit) {
        this.electricNumberNew = electricNumberNew;
        this.unit = unit;
    }

    public ElectricBillRequestDto(int electricNumberOld, int electricNumberNew, int unit, int status) {
        this.electricNumberOld = electricNumberOld;
        this.electricNumberNew = electricNumberNew;
        this.unit = unit;
        this.status = status;
    }

    public ElectricBillRequestDto(String name, int electricNumberOld, int electricNumberNew, int unit, int status) {
        this.name = name;
        this.electricNumberOld = electricNumberOld;
        this.electricNumberNew = electricNumberNew;
        this.unit = unit;
        this.status = status;
    }

    public ElectricBillRequestDto() {
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
}

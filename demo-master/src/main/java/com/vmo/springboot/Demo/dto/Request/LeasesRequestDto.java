package com.vmo.springboot.Demo.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;


public class LeasesRequestDto {
    private Date date;

    private int status;

    private int price;

    @JsonProperty("apartment_id")
    private Integer apartmentId;

    @JsonProperty("tenant_id")
    private Integer tenantId;

    public LeasesRequestDto() {
    }

    public LeasesRequestDto(Date date, int status, int price, Integer apartmentId, Integer tenantId) {
        this.date = date;
        this.status = status;
        this.price = price;
        this.apartmentId = apartmentId;
        this.tenantId = tenantId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }
}
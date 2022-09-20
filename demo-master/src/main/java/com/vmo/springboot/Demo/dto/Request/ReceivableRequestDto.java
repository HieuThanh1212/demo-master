package com.vmo.springboot.Demo.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vmo.springboot.Demo.model.ServiceOther;

import java.util.Date;
import java.util.Set;

public class ReceivableRequestDto {
    private String name;

    private int payment;

    @JsonProperty(value = "create_at")
    private Date createAt;

    @JsonProperty(value = "update_at")
    private Date updateAt;

    private int status;

    private Set<Integer> services;

    @JsonProperty(value = "ElectricBillName")
    private String electricBillName;

    @JsonProperty(value = "WaterBillName")
    private String waterBillName;

    @JsonProperty(value = "leases_id")
    private int leasesId;

    public ReceivableRequestDto() {
    }

    public ReceivableRequestDto(String name, int payment, Set<Integer> services, String electricBillName, String waterBillName, int leasesId) {
        this.name = name;
        this.payment = payment;
        this.services = services;
        this.electricBillName = electricBillName;
        this.waterBillName = waterBillName;
        this.leasesId = leasesId;
    }

    public String getElectricBillName() {
        return electricBillName;
    }

    public void setElectricBillName(String electricBillName) {
        this.electricBillName = electricBillName;
    }

    public String getWaterBillName() {
        return waterBillName;
    }

    public void setWaterBillName(String waterBillName) {
        this.waterBillName = waterBillName;
    }

    public int getLeasesId() {
        return leasesId;
    }

    public void setLeasesId(int leasesId) {
        this.leasesId = leasesId;
    }

    public ReceivableRequestDto(String name, int payment, Date createAt, Date updateAt, int status, Set<Integer> services, String electricBillName, String waterBillName, int leasesId) {
        this.name = name;
        this.payment = payment;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.services = services;
        this.electricBillName = electricBillName;
        this.waterBillName = waterBillName;
        this.leasesId = leasesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Integer> getServices() {
        return services;
    }

    public void setServices(Set<Integer> services) {
        this.services = services;
    }

}

package com.vmo.springboot.Demo.dto.Respone;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.vmo.springboot.Demo.model.ElectricBill;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.ServiceOther;
import com.vmo.springboot.Demo.model.WaterBill;

import java.util.Date;
import java.util.Set;

public class ReceivableResponseDto {
    private Integer id;

    private String name;

    @JsonProperty(value = "create_at")
    private Date createAt;

    @JsonProperty(value = "update_at")
    private Date updateAt;

    private int status;

    private Set<ServiceOther> serviceOthers;

    @JsonProperty(value = "electric_bill")
    private ElectricBill electricBill;

    @JsonProperty(value = "water_bill")
    private WaterBill waterBill;

    private Leases leases;

    private String Total;

    public ReceivableResponseDto() {
    }

    public ReceivableResponseDto(Integer id, String name, Date createAt, Date updateAt, int status, Set<ServiceOther> serviceOthers, ElectricBill electricBill, WaterBill waterBill, Leases leases, String total) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.serviceOthers = serviceOthers;
        this.electricBill = electricBill;
        this.waterBill = waterBill;
        this.leases = leases;
        Total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<ServiceOther> getServiceOthers() {
        return serviceOthers;
    }

    public void setServiceOthers(Set<ServiceOther> serviceOthers) {
        this.serviceOthers = serviceOthers;
    }

    public ElectricBill getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(ElectricBill electricBill) {
        this.electricBill = electricBill;
    }

    public WaterBill getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(WaterBill waterBill) {
        this.waterBill = waterBill;
    }

    public Leases getLeases() {
        return leases;
    }

    public void setLeases(Leases leases) {
        this.leases = leases;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}

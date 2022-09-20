package com.vmo.springboot.Demo.model;

import com.vmo.springboot.Demo.dto.Request.WaterBillRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Water_bill")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaterBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waterbill_id")
    private int id;

    private String name;

    private Date createW;

    private Date updateW;

    private int oldBillW;

    private int newBillW;

    private int unit;

    private int status;




    public void WaterBill(String name, int oldBillW, int newBillW, int unit, int status) {
        this.name = name;
        this.oldBillW = oldBillW;
        this.newBillW = newBillW;
        this.unit = unit;
        this.status = status;
    }
    public void update(WaterBillRequestDto waterBillRequestDto, WaterBill waterBill) {
        this.name = waterBillRequestDto.getName();
        this.createW = waterBill.getCreateW();
        this.updateW = waterBillRequestDto.getUpdateAt();
        this.newBillW = waterBill.getNewBillW();
        this.newBillW = waterBillRequestDto.getWaterNumberNew();
        this.unit = waterBillRequestDto.getUnit();
        this.status = waterBill.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateW() {
        return createW;
    }

    public void setCreateW(Date createW) {
        this.createW = createW;
    }

    public Date getUpdateW() {
        return updateW;
    }

    public void setUpdateW(Date updateW) {
        this.updateW = updateW;
    }

    public int getOldBillW() {
        return oldBillW;
    }

    public void setOldBillW(int oldBillW) {
        this.oldBillW = oldBillW;
    }

    public int getNewBillW() {
        return newBillW;
    }

    public void setNewBillW(int newBillW) {
        this.newBillW = newBillW;
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

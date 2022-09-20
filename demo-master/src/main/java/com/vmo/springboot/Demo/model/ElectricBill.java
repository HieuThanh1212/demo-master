package com.vmo.springboot.Demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vmo.springboot.Demo.dto.Request.ElectricBillRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Electric_bill")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElectricBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "electricbill_id")
    private int id;
    private String name;
//    @Column(name = "createE")
//    @JsonFormat(pattern = "dd/MM/YYYY HH:mm:ss")
//    @CreationTimestamp
    private Date createE;
//    @Column(name = "updateE")
//    @JsonFormat(pattern = "dd/MM/YYYY HH:mm:ss")
//    @CreationTimestamp
    private Date updateE;
    private int oldBillE;
    private int newBillE;
    private int unit;
    private int status;


    public void
    update(ElectricBillRequestDto electricBillRequestDto, ElectricBill electricBill) {
        this.name = electricBillRequestDto.getName();
        this.createE = electricBill.getCreateE();
        this.updateE = electricBillRequestDto.getUpdateAt();
        this.oldBillE  =electricBill.getNewBillE();
        this.newBillE = electricBillRequestDto.getElectricNumberNew();
        this.unit = electricBillRequestDto.getUnit();
        this.status = electricBill.getStatus();
    }
    public ElectricBill(int id, String name,  int oldBillE, int newBillE, int unit, int status) {

        this.name = name;

        this.oldBillE = oldBillE;
        this.newBillE = newBillE;
        this.unit = unit;
        this.status = status;
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

    public Date getCreateE() {
        return createE;
    }

    public void setCreateE(Date createE) {
        this.createE = createE;
    }

    public Date getUpdateE() {
        return updateE;
    }

    public void setUpdateE(Date updateE) {
        this.updateE = updateE;
    }

    public int getOldBillE() {
        return oldBillE;
    }

    public void setOldBillE(int oldBillE) {
        this.oldBillE = oldBillE;
    }

    public int getNewBillE() {
        return newBillE;
    }

    public void setNewBillE(int newBillE) {
        this.newBillE = newBillE;
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

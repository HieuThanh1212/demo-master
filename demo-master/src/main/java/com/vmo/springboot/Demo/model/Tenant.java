package com.vmo.springboot.Demo.model;

import com.vmo.springboot.Demo.dto.Request.TenantRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Tenant")
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private int gender;

    @Column(name = "id_cart")
    private String id_cart;

    @Column(name = "status")
    private int status;


    public Tenant(String name, String email, String phone, int gender, Date dob, int age, String idCard, int status) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.id_cart = id_cart;
        this.status = status;
    }

    public void update(TenantRequestDto tenantRequestDto) {
        this.name = tenantRequestDto.getName();
        this.email = tenantRequestDto.getEmail();
        this.age = tenantRequestDto.getAge();
        this.dob = tenantRequestDto.getDob();
        this.phone = tenantRequestDto.getPhone();
        this.gender = tenantRequestDto.getGender();
        this.id_cart = tenantRequestDto.getIdCard();
        this.status = tenantRequestDto.getStatus();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getId_cart() {
        return id_cart;
    }

    public void setId_cart(String id_cart) {
        this.id_cart = id_cart;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

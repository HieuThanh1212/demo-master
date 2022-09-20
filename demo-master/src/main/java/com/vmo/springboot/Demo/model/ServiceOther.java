package com.vmo.springboot.Demo.model;


import javax.persistence.*;

@Entity
@Table(name = "Service")
public class ServiceOther {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Service_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    public ServiceOther() {
    }

    public ServiceOther(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package com.vmo.springboot.Demo.model;

import com.vmo.springboot.Demo.dto.Request.ApartmentRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
@AllArgsConstructor
@NoArgsConstructor
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private int id;

    private String name;

    private int status;

    private int arena;

    private int bedroom;

    private int bathroom;

    private String image;

    private int price;

    public Apartment(String name, int area, int price, int bathroom, int bedroom, int status, String image) {
        this.name = name;
        this.arena = area;
        this.bedroom = bedroom;
        this.price = price;
        this.bathroom = bathroom;
        this.status = status;
        this.image = image;
    }
    public void update(ApartmentRequestDto apartmentRequestDto) {
        this.name = apartmentRequestDto.getName();
        this.status = apartmentRequestDto.getStatus();
        this.arena = apartmentRequestDto.getArea();
        this.bedroom = apartmentRequestDto.getBedroom();
        this.bathroom = apartmentRequestDto.getBathroom();
        this.image = apartmentRequestDto.getImage();
        this.price = apartmentRequestDto.getPrice();
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getArena() {
        return arena;
    }

    public void setArena(int arena) {
        this.arena = arena;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}

package com.vmo.springboot.Demo.dto.Request;


public class ApartmentRequestDto {
    private String name;

    private int status;

    private int area;

    private int bedroom;

    private int bathroom;

    private String image;

    private int price;

    public ApartmentRequestDto() {
    }

    public ApartmentRequestDto(String name, int status, int area, int bedroom, int bathroom, String image, int price) {
        this.name = name;
        this.status = status;
        this.area = area;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.image = image;
        this.price = price;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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

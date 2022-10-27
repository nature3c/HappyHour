package com.example.myapplication;

public class ResturantModelClass {

    String img;
    String name;
    String deal;

    public ResturantModelClass(String name, String deal, String img) {
        this.img = img;
        this.name = name;
        this.deal = deal;
    }

    public ResturantModelClass() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }
}

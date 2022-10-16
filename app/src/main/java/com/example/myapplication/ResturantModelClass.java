package com.example.myapplication;

public class ResturantModelClass {

    String name;
    String description;
    String dealList;
    String expirationDate;

    public ResturantModelClass(String setName, String setDescription, String setDealList, String setExpirationdate) {
        name = setName;
        description = setDescription;
        dealList = setDealList;
        expirationDate = setExpirationdate;
    }

    public ResturantModelClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }

    public String getImg() {
        return name;
    }

    public void setImg(String name) {
        this.name = name;
    }

    public String getExpirationDate() {return expirationDate;}

    public void  setExpirationDate(String name) {this.expirationDate = expirationDate;}

    public String getDealList() {return dealList;}

    public void  setDealList(String name) {this.dealList = dealList;}
}

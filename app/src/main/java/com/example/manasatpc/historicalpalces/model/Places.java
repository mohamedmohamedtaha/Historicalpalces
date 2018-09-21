package com.example.manasatpc.historicalpalces.model;

/**
 * Created by ManasatPC on 21/09/18.
 */

public class Places {
    private String name,decription, country;
    private int image, rate ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Places(String name, String decription, String country, int image) {
        this.name = name;
        this.decription = decription;
        this.country = country;
        this.image = image;
        rate = 0;

    }
}

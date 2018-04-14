package com.example.admin.pizzaordering;

import java.io.Serializable;

/**
 * Created by ADMIN on 12/17/2017.
 */

public class ListProduct implements Serializable{
    public String Name;
    public String Description;
    public String Price;
    public int Image;


    public ListProduct(String name, String description, String price, int image) {
        Name = name;
        Description = description;
        Price = price;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}






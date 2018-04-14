package com.example.admin.pizzaordering;

import java.io.Serializable;

/**
 * Created by ADMIN on 12/18/2017.
 */

public class Cart implements Serializable{
    public String NameProduct;
    public long PriceProduct;
    public int ImgProduct;
    public int NumberProduct;

    public Cart(String nameProduct, long priceProduct, int imgProduct, int numberProduct) {
        NameProduct = nameProduct;
        PriceProduct = priceProduct;
        ImgProduct = imgProduct;
        NumberProduct = numberProduct;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public long getPriceProduct() {
        return PriceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        PriceProduct = priceProduct;
    }

    public int getImgProduct() {
        return ImgProduct;
    }

    public void setImgProduct(int imgProduct) {
        ImgProduct = imgProduct;
    }

    public int getNumberProduct() {
        return NumberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        NumberProduct = numberProduct;
    }
}

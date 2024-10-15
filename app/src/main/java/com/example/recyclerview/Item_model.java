package com.example.recyclerview;

public class Item_model {
    String name;
    String describe;
    int img;
    int price;

    public Item_model(String name, String describe, int img, int price) {
        this.name = name;
        this.describe = describe;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public int getImg() {
        return img;
    }

    public int getPrice() {
        return price;
    }
}



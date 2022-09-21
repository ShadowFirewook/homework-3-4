package com.example.homework_3_4;

import java.io.Serializable;

public class Continent implements Serializable {

    private String name;
    private String image;

    public Continent(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

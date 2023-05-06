package com.example.recyclerviewdemo;

import java.util.ArrayList;

public class Footballer {
    private String name, details, speech;
    private Integer imageId;

    public Footballer(String name, String details, Integer imageId) {
        this(name, details, "HALA MADRID!", imageId);
    }

    public Footballer(String name, String details, String speech, Integer imageId) {
        this.name = name;
        this.details = details;
        this.speech = speech;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Integer getImageId() {
        return imageId;
    }

    public String getSpeech() {
        return speech;
    }
}

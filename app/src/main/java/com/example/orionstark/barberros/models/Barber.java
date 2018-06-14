package com.example.orionstark.barberros.models;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Barber {

    public static ArrayList<Barber> barbers = new ArrayList<>();

    String id;
    String barber_name;
    ArrayList<String> times;
    ArrayList<String> services;
    String latitude;
    String longitude;
    String description;
    String no_telp;
    Bitmap image;

    public Barber(
            String id, String barber_name,
            ArrayList<String> times, ArrayList<String> services,
            String latitude, String longitude, String description,
            String no_telp, Bitmap image) {
        this.id = id;
        this.barber_name = barber_name;
        this.times = times;
        this.services = services;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.no_telp = no_telp;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getBarber_name() {
        return barber_name;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public Bitmap getImage() {
        return image;
    }
}

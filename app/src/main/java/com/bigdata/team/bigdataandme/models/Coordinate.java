package com.bigdata.team.bigdataandme.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Coordinates")
public class Coordinate {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public Double latitude;

    public Double longitude;

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
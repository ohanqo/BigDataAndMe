package com.bigdata.team.bigdataandme.models.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bigdata.team.bigdataandme.models.Coordinate;

import java.util.List;

@Dao
public interface CoordinateDao {

    @Insert
    void insert(Coordinate coordinate);

    @Query("SELECT * FROM Coordinates")
    LiveData<List<Coordinate>> getCoordinates();
}
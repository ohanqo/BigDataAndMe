package com.bigdata.team.bigdataandme.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.bigdata.team.bigdataandme.models.Coordinate;
import com.bigdata.team.bigdataandme.repositories.CoordinateRepository;

import java.util.List;

public class CoordinateViewModel extends AndroidViewModel {

    private CoordinateRepository coordinateRepository;
    private LiveData<List<Coordinate>> coordinates;

    public CoordinateViewModel(@NonNull Application application) {
        super(application);
        coordinateRepository = new CoordinateRepository(application);
        coordinates = coordinateRepository.getCoordinates();
    }

    public void insert(Coordinate coordinate) {
        coordinateRepository.insert(coordinate);
    }

    public LiveData<List<Coordinate>> getCoordinates() {
        return coordinates;
    }
}
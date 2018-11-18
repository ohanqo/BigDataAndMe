package com.bigdata.team.bigdataandme.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.bigdata.team.bigdataandme.models.AppDatabase;
import com.bigdata.team.bigdataandme.models.Coordinate;
import com.bigdata.team.bigdataandme.models.dao.CoordinateDao;

import java.util.List;

public class CoordinateRepository {

    private LiveData<List<Coordinate>> coordinates;
    private CoordinateDao coordinateDao;

    public CoordinateRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        coordinateDao = database.coordinateDao();
        coordinates = coordinateDao.getCoordinates();
    }

    public void insert(Coordinate coordinate) {
        new InsertCoordinateAsyncTask(coordinateDao).execute(coordinate);
    }

    public LiveData<List<Coordinate>> getCoordinates() {
        return coordinates;
    }

    private static class InsertCoordinateAsyncTask extends AsyncTask<Coordinate, Void, Void> {

        private CoordinateDao coordinateDao;

        public InsertCoordinateAsyncTask(CoordinateDao coordinateDao) {
            this.coordinateDao = coordinateDao;
        }

        @Override
        protected Void doInBackground(Coordinate... coordinates) {
            coordinateDao.insert(coordinates[0]);
            return null;
        }
    }
}
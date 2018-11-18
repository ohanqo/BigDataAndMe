package com.bigdata.team.bigdataandme.models;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.bigdata.team.bigdataandme.models.dao.CoordinateDao;

@Database(entities = {Coordinate.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract CoordinateDao coordinateDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "BigDataAndMeDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    /**
     * Mock coordinates
     */

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new MockCoordinatesAsyncTask(instance).execute();
        }
    };

    private static class MockCoordinatesAsyncTask extends AsyncTask<Void, Void, Void> {

        private CoordinateDao coordinateDao;

        private MockCoordinatesAsyncTask(AppDatabase appDatabase) {
            coordinateDao = appDatabase.coordinateDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            coordinateDao.insert(new Coordinate(123.4567, 765.4123));
            coordinateDao.insert(new Coordinate(76.5432, 32.123));
            return null;
        }
    }
}

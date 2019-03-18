package com.bigdata.team.bigdataandme;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bigdata.team.bigdataandme.models.Coordinate;
import com.bigdata.team.bigdataandme.viewmodels.CoordinateViewModel;

import java.util.List;
import java.util.Random;

// TODO: switch to fragment
public class LocalisationActivity extends AppCompatActivity {

    private CoordinateViewModel coordinateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);

        coordinateViewModel = ViewModelProviders.of(this).get(CoordinateViewModel.class);
        coordinateViewModel.getCoordinates().observe(this, new Observer<List<Coordinate>>() {
            @Override
            public void onChanged(@Nullable List<Coordinate> coordinates) {
                Log.d("COORDINATES Size ->", String.valueOf(coordinates.size()));
                for(Coordinate coordinate: coordinates) {
                    Log.d("——Coordinate n°",
                            String.valueOf(coordinate.id) +
                            ", LAT : " + coordinate.latitude.toString() +
                                    ", LONG : " + coordinate.longitude.toString()
                    );
                }
            }
        });
    }

    public void addRandomCoordinate(View v) {
        double start = 0;
        double end = 800;

        double randomLatitude = new Random().nextDouble();
        double latitude = start + (randomLatitude * (end - start));

        double randomLongitude = new Random().nextDouble();
        double longitude = start + (randomLongitude * (end - start));

        coordinateViewModel.insert(new Coordinate(latitude, longitude));
    }
}

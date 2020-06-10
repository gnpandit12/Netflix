package com.next.netflix.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;

import com.next.netflix.R;
import com.next.netflix.databinding.ActivityMainBinding;
import com.next.netflix.model.MovieTwoDataClass;
import com.next.netflix.model.MoviesOneDataClass;
import com.next.netflix.model.RecyclerViewOneAdapter;
import com.next.netflix.model.RecyclerViewTwoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewTwo;
    private ArrayList<MoviesOneDataClass> mMoviesOneDataClassArrayList;
    private RecyclerViewOneAdapter mRecyclerViewOneAdapter;
    private String TAG = "main_activity";
    private ArrayList<MovieTwoDataClass> mMovieTwoDataClassArrayList;
    private RecyclerViewTwoAdapter mRecyclerViewTwoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.overridePendingTransition(R.anim.enter,
                R.anim.exit);
        mRecyclerViewOne = mainBinding.recyclerViewOne;
        mRecyclerViewTwo = mainBinding.recyclerViewTwo;
        mRecyclerViewOne.setHasFixedSize(true);
        mRecyclerViewTwo.setHasFixedSize(true);
        mRecyclerViewOne.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewTwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mMoviesOneDataClassArrayList = new ArrayList<>();
        mMovieTwoDataClassArrayList = new ArrayList<>();
        setUpRecyclerViewOne();
        setUpRecyclerViewTwo();


    }

    private void setUpRecyclerViewTwo() {
        Log.d(TAG, "setUpRecyclerViewTwo: ");
        for (int i=0; i< 6; i++){
            MovieTwoDataClass movieTwoDataClass = new MovieTwoDataClass();
            movieTwoDataClass.setmMovieTwoImage(getResources().getDrawable(R.drawable.harray_potter_image));
            movieTwoDataClass.setmMovieTitle("Harry Potter");
            mMovieTwoDataClassArrayList.add(movieTwoDataClass);
            mRecyclerViewTwoAdapter = new RecyclerViewTwoAdapter(this, mMovieTwoDataClassArrayList);
        }
        mRecyclerViewTwo.setAdapter(mRecyclerViewTwoAdapter);
        mRecyclerViewTwoAdapter.notifyDataSetChanged();
    }

    private void setUpRecyclerViewOne() {
        Log.d(TAG, "setUpRecyclerViewOne: ");
        for (int i=0; i< 6; i++){
            MoviesOneDataClass moviesOneDataClass = new MoviesOneDataClass();
            moviesOneDataClass.setMovieImageDrawable(getResources().getDrawable(R.drawable.the_lion_king));
            moviesOneDataClass.setMovieOneTitle("The Lion King");
            mMoviesOneDataClassArrayList.add(moviesOneDataClass);
            mRecyclerViewOneAdapter = new RecyclerViewOneAdapter(this, mMoviesOneDataClassArrayList);
        }
        mRecyclerViewOne.setAdapter(mRecyclerViewOneAdapter);
        mRecyclerViewOneAdapter.notifyDataSetChanged();
    }
}
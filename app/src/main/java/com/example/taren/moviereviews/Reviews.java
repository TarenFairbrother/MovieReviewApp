package com.example.taren.moviereviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by taren on 1/4/2018.
 */

public class Reviews extends AppCompatActivity {

    ListView lstreviews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);

        DBMovieReviews db = new DBMovieReviews(this);

        List<Movie> reviews = db.getAllReviews();




        ArrayAdapter<Movie> itemsAdapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, reviews);

        lstreviews.setAdapter(itemsAdapter);

    }


}

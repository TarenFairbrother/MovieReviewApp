package com.example.taren.moviereviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner dropdown;
    EditText title;
    EditText review;
    Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Populatespinner();

        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createReview();

                goToReviews(view);


            }
        });


    }

    public void Populatespinner(){

        dropdown = findViewById(R.id.spnRating);

        String[] items = new String[]{"1","2", "3", "4", "5", "6", "7", "8", "9", "10"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

    }

    public void createReview(){

        title = findViewById(R.id.txtTitle);
        review = findViewById(R.id.txtReview);

        DBMovieReviews db = new DBMovieReviews(this);

        Log.d("Insert ", "Inserting..");

        db.addMovieReview(new Movie(title.getText().toString() ,review.getText().toString(), Integer.decode(dropdown.getSelectedItem().toString())));


    }

    public void goToReviews(View view){

        Intent intent = new Intent(this, Reviews.class);

        startActivity(intent);

    }
}

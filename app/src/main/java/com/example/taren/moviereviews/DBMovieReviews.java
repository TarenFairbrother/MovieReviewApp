package com.example.taren.moviereviews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMovieReviews extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MovieReviews";
    // Contacts table name
    private static final String Table_Movies = "Movies";
    private static final String MovieTitle = "MovieTitle";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String Movie_Review = "MovieReview";
    private static final String Rating = "Rating";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + Table_Movies + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + MovieTitle + " TEXT,"
        + Movie_Review + " TEXT " + Rating + "INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Table_Movies);
// Creating tables again
        onCreate(db);
    }

    public void addMovieReview(Movie movie){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MovieTitle, movie.getTitle());

        values.put(Movie_Review, movie.getDescription());

        values.put(Rating, movie.getRating());

        db.insert(Table_Movies, null, values);

        db.close();

    }

    public Movie getReviewByMovie(String movie1) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Table_Movies, new String[] {MovieTitle,Movie_Review,Rating}, MovieTitle + "=?", new String[] {
                movie1 }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Movie movie = new Movie(cursor.getString(0),
                cursor.getLong(1), Integer.parseInt(cursor.getString(2)));

        return movie;

    }

}

package sg.edu.rp.c346.id18015518.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    TextView title, year, theatre, desc, calendar, genre;
    RatingBar ratingBar;
    ImageView rated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.textViewTitle);
        year = findViewById(R.id.textViewYear);
        genre = findViewById(R.id.textViewGenre);
        theatre = findViewById(R.id.textViewInTheatre);
        desc = findViewById(R.id.textViewDescription);
        rated = findViewById(R.id.imageViewMovie);
        calendar = findViewById(R.id.textViewCalendar);


        ratingBar = findViewById(R.id.ratingBar);

        Intent i = getIntent();

        String mTitle = i.getStringExtra("title");
        title.setText(mTitle);

        int mYear = i.getIntExtra("year", -1);
        year.setText(mYear + " - ");

        String mGenre = i.getStringExtra("genre");
        genre.setText(mGenre);

        String mTheatre = i.getStringExtra("theatre");
        theatre.setText(mTheatre);

        String mCalendar = i.getStringExtra("calendar");
        theatre.setText(mCalendar + "");

        String mDesc = i.getStringExtra("description");
        desc.setText(mDesc);

        int rating = i.getIntExtra("rating", -1);
        ratingBar.setRating(rating);

        String mRated = i.getStringExtra("rated");
        if (mRated.equals("G")) {
            rated.setImageResource(R.drawable.rating_g);
        }else if (mRated.equals("M18")){
            rated.setImageResource(R.drawable.rating_m18);
        }else if (mRated.equals("NC16")){
            rated.setImageResource(R.drawable.rating_nc16);
        }else if (mRated.equals("PG")){
            rated.setImageResource(R.drawable.rating_pg);
        }else if (mRated.equals("PG13")){
            rated.setImageResource(R.drawable.rating_pg13);
        }else{
            rated.setImageResource(R.drawable.rating_r21);
        }
    }
}

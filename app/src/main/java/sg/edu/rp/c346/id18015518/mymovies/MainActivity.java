package sg.edu.rp.c346.id18015518.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        Calendar thedate = Calendar.getInstance();
        thedate.set(2020,0,22);

        alMovieList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2019,11,23);
        Movie Item1 = new Movie ("The Avengers", 2012, "PG13", "Action", date1, "Golden Village", "Nick Fury", 4);
        alMovieList.add(Item1);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieSelected = alMovieList.get(position);
                String title = movieSelected.getTitle();
                int year = movieSelected.getYear();
                String rated = movieSelected.getRated();
                String genre = movieSelected.getGenre();
                String theatre = movieSelected.getIn_theatre();
                String description = movieSelected.getDescription();
                int rating = movieSelected.getRating();
                Calendar calendar = movieSelected.getWatched_on();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("title", title);
                intent.putExtra("year", year);
                intent.putExtra("rated", rated);
                intent.putExtra("genre", genre);
                intent.putExtra("theatre", theatre);
                intent.putExtra("description", description);
                intent.putExtra("rating", rating);
                intent.putExtra("calendar", calendar);
                startActivity(intent);
            }
        });
    }


}

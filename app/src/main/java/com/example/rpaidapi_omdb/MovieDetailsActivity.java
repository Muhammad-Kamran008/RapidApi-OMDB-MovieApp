package com.example.rpaidapi_omdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpaidapi_omdb.Listeners.OnFetchDetailListener;
import com.example.rpaidapi_omdb.Listeners.OnRatingsApiListener;
import com.example.rpaidapi_omdb.Model.MovieRatings;
import com.example.rpaidapi_omdb.Model.MovieResult;
import com.example.rpaidapi_omdb.ui.CastRecyclerAdapter;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView textView_movie_detail_name, textView_movie_detail_year, textView_movie_detail_length, textView_movie_detail_rating, textView_movie_detail_votes, textView_movie_detail_plot;
    RecyclerView recycler_cast, recycler_specs;
    ImageView imageView_movie_detail_poster;

    CastRecyclerAdapter castRecyclerAdapter;

    // SpecsAdapter specsAdapter;
    ScrollView details_container;
    ProgressDialog dialog;

    RequestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movie Details");

        textView_movie_detail_name = findViewById(R.id.textView_movie_name);
        textView_movie_detail_year = findViewById(R.id.textView_movie_released);
        textView_movie_detail_length = findViewById(R.id.textView_movie_runtime);
        textView_movie_detail_rating = findViewById(R.id.textView_movie_rating);
        textView_movie_detail_votes = findViewById(R.id.textView_movie_votes);
        textView_movie_detail_plot = findViewById(R.id.textview_movie_plot);
        recycler_cast = findViewById(R.id.recycler_movie_cast);
        //  recycler_specs = findViewById(R.id.recycler_specs);
        imageView_movie_detail_poster = findViewById(R.id.imageview_movie_poster);
        details_container = findViewById(R.id.details_container);
        manager = new RequestManager(this);

        String id = getIntent().getStringExtra("movie_id");

        dialog = new ProgressDialog(this);
        dialog.setTitle("Please Wait");
        dialog.show();


        RequestManager manager = new RequestManager(this);
        //  manager.getMovieDetails(listener, id);
        showResult((MovieResult) getIntent().getSerializableExtra("details"));
        manager.searchMovieRating(listener,id);


    }



    private OnRatingsApiListener listener = new OnRatingsApiListener() {
        @Override
        public void onResponse(MovieRatings ratings) {
            dialog.dismiss();
            if (ratings==null){
                Toast.makeText(MovieDetailsActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showRating(ratings);

        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MovieDetailsActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showRating(MovieRatings ratings) {
        textView_movie_detail_rating.setText(String.valueOf(ratings.getRating()));
        textView_movie_detail_votes.setText(String.valueOf(ratings.getRatingsHistograms().get("IMDb Staff").getTotalRatings() )+ " IMDB");


    }

    private void showResult(MovieResult response) {
        textView_movie_detail_name.setText(response.getTitle());
        textView_movie_detail_year.setText("Year Released: " + response.getYear());
        textView_movie_detail_length.setText("Duration: " + response.getRunningTimeInMinutes());

//        textView_movie_detail_plot.setText(response.getPlot());

        try {
            Picasso.get().load(response.getImage().getUrl()).into(imageView_movie_detail_poster);
        } catch (Exception e) {
            e.printStackTrace();
        }

        recycler_cast.setHasFixedSize(true);
        recycler_cast.setLayoutManager(new GridLayoutManager(this, 1));
        castRecyclerAdapter = new CastRecyclerAdapter(this, response.getPrincipals());
        recycler_cast.setAdapter(castRecyclerAdapter);

//        recycler_specs.setHasFixedSize(true);
//        recycler_specs.setLayoutManager(new GridLayoutManager(this, 1));
//        specsAdapter = new SpecsAdapter(this, response.getTechnical_specs());
//        recycler_specs.setAdapter(specsAdapter);

        details_container.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
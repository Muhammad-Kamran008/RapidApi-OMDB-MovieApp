package com.example.rpaidapi_omdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpaidapi_omdb.Listeners.OnMovieClickListener;
import com.example.rpaidapi_omdb.Listeners.OnSearchApiListener;
import com.example.rpaidapi_omdb.Model.MovieResult;
import com.example.rpaidapi_omdb.Model.SearchResult;
import com.example.rpaidapi_omdb.ui.HomeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    SearchView searchView;
    RecyclerView recyclerView;
    RequestManager manager;
    ProgressDialog dialog;
    HomeRecyclerAdapter adapter;

    List<MovieResult> movieResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new RequestManager(this);
        searchView = findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.recycler_view_home);
        dialog = new ProgressDialog(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Please Wait....");
                dialog.show();
                manager.searchMovie(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnSearchApiListener listener = new OnSearchApiListener() {
        @Override
        public void onResponse(SearchResult searchResult) {
            dialog.dismiss();
            if (searchResult == null) {
                Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                return;
            }
            movieResults = searchResult.getResults();
            showResult(searchResult);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(SearchResult searchResult) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new HomeRecyclerAdapter(this, searchResult.getResults(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onMovieClicked(String id) {
        MovieResult newMovieResult = null;
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        for (MovieResult mr : movieResults) {
            if (mr.getId().equals(id)) {
                newMovieResult = mr;
            }
        }
        Log.d("movie", "onMovieClicked: "+newMovieResult.getTitle());
        startActivity(new Intent(MainActivity.this, MovieDetailsActivity.class).putExtra("data", id).putExtra("details",newMovieResult));


    }
}


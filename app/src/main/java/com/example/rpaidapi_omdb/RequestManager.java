package com.example.rpaidapi_omdb;

import android.app.appsearch.AppSearchManager;
import android.content.Context;
import android.widget.Toast;

import com.example.rpaidapi_omdb.Listeners.OnSearchApiListener;
import com.example.rpaidapi_omdb.Model.SearchResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://online-movie-database.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void searchMovie(OnSearchApiListener listener, String movie_name) {
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchResult> call = getMovies.callMovies(movie_name);

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Could not fetch data", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });

    }


    public interface getMovies {
        @Headers({
                "Accept: application/json",
                "X-RapidAPI-Host: online-movie-database.p.rapidapi.com",
                "X-RapidAPI-Key: 64c6729453msh2b0343ebc9e0fdap12ce19jsn2fb910702d24"
        })
        @GET("title/find/")
        Call<SearchResult> callMovies(
                @Query("q") String movie_name
        );
    }

}

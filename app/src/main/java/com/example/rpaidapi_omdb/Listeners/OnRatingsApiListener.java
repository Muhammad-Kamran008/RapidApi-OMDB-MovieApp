package com.example.rpaidapi_omdb.Listeners;

import com.example.rpaidapi_omdb.Model.MovieRatings;

public interface OnRatingsApiListener {
    void onResponse(MovieRatings ratings);
    void onError(String message);

}

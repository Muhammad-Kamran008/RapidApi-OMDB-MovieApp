package com.example.rpaidapi_omdb.Listeners;

import com.example.rpaidapi_omdb.Model.MovieResult;

public interface OnFetchDetailListener {
    void onFetched(MovieResult response, String message);
    void onError(String message);
}
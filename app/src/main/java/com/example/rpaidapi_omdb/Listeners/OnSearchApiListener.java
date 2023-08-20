package com.example.rpaidapi_omdb.Listeners;

import com.example.rpaidapi_omdb.Model.SearchResult;

public interface OnSearchApiListener {
    void onResponse(SearchResult searchResult);
    void onError(String message);
}

package com.example.newsapirecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<Array> getNews(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey
    );
}

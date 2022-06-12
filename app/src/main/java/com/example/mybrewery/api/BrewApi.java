package com.example.mybrewery.api;


import com.example.mybrewery.models.BreweryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface BrewApi {
    @GET("search.php")
    Call<BreweryResponse> getRestaurants(
            @Query("f") String s

    );
}


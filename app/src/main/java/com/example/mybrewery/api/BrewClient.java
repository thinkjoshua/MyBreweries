package com.example.mybrewery.api;



import static com.example.mybrewery.models.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrewClient {
    private static Retrofit retrofit = null;

    public static BrewApi getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(BrewApi.class);
    }

}


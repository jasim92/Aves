package com.example.aves.ApiServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    public static final String BASE_URL = "https://api.unsplash.com";
    private static ApiController apiController;
    private static Retrofit retrofit;

    public ApiController() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiController getInstance()
    {
        if (apiController==null)
        {
            apiController = new ApiController();
        }
        return apiController;
    }

    public ApiService getApis()
    {
        return retrofit.create(ApiService.class);
    }
}

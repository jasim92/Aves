package com.example.aves.ApiServices;

import com.example.aves.Models.AvesProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/photos/?client_id=8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8")
    Call<List<AvesProfile>> getProfile();
}

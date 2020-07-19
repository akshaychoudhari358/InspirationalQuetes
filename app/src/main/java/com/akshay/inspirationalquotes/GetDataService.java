package com.akshay.inspirationalquotes;;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/quotes")
    Call<List<Quotes>> getAllPhotos();
}

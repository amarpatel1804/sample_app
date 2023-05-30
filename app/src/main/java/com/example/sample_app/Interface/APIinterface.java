package com.example.sample_app.Interface;

import com.example.sample_app.Model.PojoModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("data.json")
    Call<PojoModel> getData();

}

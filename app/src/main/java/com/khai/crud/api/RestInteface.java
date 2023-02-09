package com.khai.crud.api;

import com.khai.crud.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestInteface {


    @GET("products/{id}")
    Call<Product> getById(@Path("id") String id);
}

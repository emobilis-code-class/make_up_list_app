package com.mit.makeupapp.api;

import com.mit.makeupapp.data.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    /*make a GET Api call*/
    @GET("v1/products.json")
    Call<List<Product>> getProducts();

}

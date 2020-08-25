package com.mit.makeupapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mit.makeupapp.api.ApiService;
import com.mit.makeupapp.api.RetrofitClient;
import com.mit.makeupapp.data.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progressBar);
        getProducts();
    }

    /*
    * we have data api - json
    * we configure - get the json - and convert to java - Retrofit
    * - We add depency
    *  - We have POJO - class -
    * -  Glide
    * -Set up recycler -
    * -Tie up
    *
    * */
    private void getProducts(){
        final String TAG = "Products API";
        RetrofitClient.getClient(this)
                .create(ApiService.class)
                .getProducts()
                .enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()){
                            Log.e(TAG,"Success "+response.body());
                            //show on a recyclerview
                            recyclerView.setAdapter(new ProductRecyclerViewAdapter(response.body(),
                                    MainActivity.this));
                        }else{
                            Log.e(TAG,"Error "+response.errorBody());
                            Toast.makeText(MainActivity.this,"Something went Try again",Toast.LENGTH_LONG).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {
                        //no internet//json is wrong
                        Log.e(TAG,"Failure "+t.getMessage());
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this,"Something went Try again",Toast.LENGTH_LONG).show();


                    }
                });


    }
}
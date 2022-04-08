package com.example.newsapirecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.newsapirecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> modelList;
    ArrayList<Array> arrayList;
    Adapter adapter;
    String apiKey = "1170889f3a16417d8e92bb03417dbd90";
    String sources = "google-news-in";
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        modelList = new ArrayList<>();
        arrayList = new ArrayList<>();

        GetData();

    }
    public void GetData() {

        Call<Array> arrayCall = ApiUtilities.getApiInterface().getNews(sources, apiKey);
        arrayCall.enqueue(new Callback<Array>() {
            @Override
            public void onResponse(Call<Array> call, Response<Array> response) {
                Array objArray = response.body();
                modelList.addAll(response.body().getArticles());
                adapter = new Adapter(MainActivity.this, modelList);
                activityMainBinding.recyclerview.setAdapter(adapter);
                activityMainBinding.recyclerview.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Array> call, Throwable t) {

            }
        });

    }
}
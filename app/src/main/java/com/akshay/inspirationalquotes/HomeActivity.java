package com.akshay.inspirationalquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Quotes> quotes;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<Quotes>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Quotes>>() {

            @Override
            public void onResponse(Call<List<Quotes>> call, Response<List<Quotes>> response) {

                generateDataList(response.body());
                quotes = (ArrayList<Quotes>) response.body();
                    for(Quotes r: quotes){
                        Log.i("testing123", "********"+r.getText());
                        Log.i("testing123", "********"+r.getAuthor());
                    }


            }

            @Override
            public void onFailure(Call<List<Quotes>> call, Throwable t) {
                Log.i("Error", "" + t.getMessage());
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Quotes> quotes) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,quotes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}
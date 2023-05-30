package com.example.sample_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sample_app.Adpter.RecyclerAdpter;
import com.example.sample_app.Interface.APIinterface;
import com.example.sample_app.Model.PojoModel;
import com.example.sample_app.RetrofitService.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

        RecyclerAdpter adpter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        
        listingData();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        if (!isInternetAvailable()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again.")
                    .setPositiveButton("OK", null)
                    .show();
        }




    }

    private void listingData() {
        APIinterface apIinterface= Retrofit.getRetrofit().create(APIinterface.class);
        Call<PojoModel> listingData=apIinterface.getData();
        listingData.enqueue(new Callback<PojoModel>() {
            @Override
            public void onResponse(Call<PojoModel> call, Response<PojoModel> response) {

                if(response.isSuccessful()){
                    if (response.body().getDetail()!=null && response.body().getDetail().size()>0){

                        adpter=new RecyclerAdpter(response.body().getDetail());
                        recyclerView.setAdapter(adpter);
                    }
                    else {

                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Something went wrong, Try again ",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PojoModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
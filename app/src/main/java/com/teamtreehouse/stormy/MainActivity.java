package com.teamtreehouse.stormy;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = "aa9f83f9dbf2f004fadd06d8c26925fc";
        Double latitud = -34.603333;
        Double longitud = -58.381667;
        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitud + "," + longitud;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if(response.isSuccessful()) {
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Exception caught: ", e);
                }

            }
        });

        Log.d(TAG,"Main UI code is running!");

    }


}
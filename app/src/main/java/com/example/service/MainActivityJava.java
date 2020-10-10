package com.example.service;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityJava extends AppCompatActivity {

    private final String TAG = "MainJava:";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG," On Create!");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG," On Activity!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG," On Resume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG," On Pause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG," On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG," On Destroy!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG," On Restart!");
    }
}

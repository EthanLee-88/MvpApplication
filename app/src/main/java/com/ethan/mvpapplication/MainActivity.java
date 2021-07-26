package com.ethan.mvpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ethan.mvpapplication.mvp.realview.MvpDataActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickT(View view){
        start();
    }

    private void start(){
        Intent intent = new Intent(this, MvpDataActivity.class);
        startActivity(intent);
    }

}
package com.maid.giproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class View_btn_NFL extends AppCompatActivity {


    ImageButton IMG1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_btn_nfl);
        IMG1 = findViewById(R.id.img_1);
    }
    public void img(View v){
        finish();
    }
}
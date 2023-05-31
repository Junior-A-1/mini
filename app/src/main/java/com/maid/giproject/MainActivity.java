package com.maid.giproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton IMG1,FRAG_BTN_1,FRAG_BTN_2,FRAG_BTN_3,FRAG_BTN_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IMG1 = findViewById(R.id.img_1);
        FRAG_BTN_1 = findViewById(R.id.frag_btn_1);
        FRAG_BTN_2 = findViewById(R.id.frag_btn_2);
        FRAG_BTN_3 = findViewById(R.id.frag_btn_3);
        FRAG_BTN_4 = findViewById(R.id.frag_btn_4);



        FRAG_BTN_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag1 frag1 = new frag1();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_2,frag1);
                fragmentTransaction.commit();
            }
        });

        FRAG_BTN_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag2 frag2 = new frag2();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_2,frag2);
                fragmentTransaction.commit();
            }
        });

        FRAG_BTN_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag3 frag3 = new frag3();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_2,frag3);
                fragmentTransaction.commit();
            }
        });
        FRAG_BTN_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag4 frag4 = new frag4();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_2,frag4);
                fragmentTransaction.commit();
            }
        });



        replaceFragment(new frag4());

    }

//    public void img(View v){
//        Intent intent = new Intent(MainActivity.this, Activity1.class );
//        startActivity(intent);
//    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_2,fragment);
        fragmentTransaction.commit();
    }


    public void button_1(View v){
        Intent intent = new Intent(MainActivity.this, Circket.class);
        startActivity(intent);
    }

}
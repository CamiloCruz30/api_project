package com.camilocruz.picsumapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initActivityImagesInfo(View view) {
        Intent intent = new Intent(getApplicationContext(),PictureMenu.class);
        startActivity(intent);
    }
}
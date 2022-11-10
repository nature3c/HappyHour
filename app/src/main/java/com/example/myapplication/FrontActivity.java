package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FrontActivity extends AppCompatActivity {

    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        next_button = (Button) findViewById(R.id.next);

        next_button.setOnClickListener(v -> {
            Intent intent = new Intent(FrontActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrontActivity extends AppCompatActivity {

    Button next_button;
    Button social_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        next_button = (Button) findViewById(R.id.next);

        next_button.setOnClickListener(v -> {
            Intent intent = new Intent(FrontActivity.this, MainActivity.class);
            startActivity(intent);
        });
        social_button = (Button) findViewById(R.id.social);
        social_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://replbio.hy9er.repl.co/"));
                startActivity(intent);
            }
        });


    }

}
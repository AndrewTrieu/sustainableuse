package com.example.electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Settings extends AppCompatActivity {
    ImageView back;
    Button changeUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        back = findViewById(R.id.imageView24);
        changeUsername = findViewById(R.id.button6);
        back();
    }

    public void back() {
        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        });
    }

    public void changeUsername() {
        changeUsername.setOnClickListener(view -> {
            Intent intent = new Intent(this, ChangeUsername.class);
            startActivity(intent);
        });
    }
}
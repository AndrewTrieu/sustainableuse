package com.example.electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    String username;
    TextView name, usage;
    ImageView back, setting;
    Button usageBtn, oasisBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = getIntent().getStringExtra("username");
        name = findViewById(R.id.textView12);
        name.setText(username);
        usage = findViewById(R.id.textView11);
        back = findViewById(R.id.imageView17);
        setting = findViewById(R.id.imageView18);
        usageBtn = findViewById(R.id.button4);
        oasisBtn = findViewById(R.id.button5);
        logOut();
        startSetting();
        startUsage();
    }

    public void logOut() {
        back.setOnClickListener(view -> {
                Toast.makeText(Home.this, "Logged out successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        });
    }

    public void startSetting() {
        setting.setOnClickListener(view -> {
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
        });
    }

    public void startUsage() {
        usageBtn.setOnClickListener(view -> {
                Intent intent = new Intent(this, Usage.class);
                startActivity(intent);
        });
    }
}
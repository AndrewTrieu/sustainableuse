package com.example.electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    String username;
    TextView name, usage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = getIntent().getStringExtra("username");
        name = findViewById(R.id.textView12);
        name.setText(username);
        usage = findViewById(R.id.textView11);
    }
}
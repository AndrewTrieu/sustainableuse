package com.example.electricity;

import static com.example.electricity.DatabaseHelper.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper database;
    Button btnLogin, btnSignup;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button2);
        btnSignup = findViewById(R.id.button3);
        checkUser();
        signUp();
    }

    public void checkUser() {
        btnLogin.setOnClickListener(view -> {
            String sUsername = username.getText().toString().trim();
            String sPassword = password.getText().toString().trim();
            int checkUser = database.checkData(sUsername, sPassword);
            if (checkUser == 1) {
                Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Home.class);
                intent.putExtra("username", sUsername);
                startActivity(intent);
                finish();
            } else if (checkUser == 2){
                Toast.makeText(MainActivity.this, "Username and password cannot be empty", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Account does not exist or incorrect user information", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void signUp() {
        btnSignup.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });
    }


}
package com.example.electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DatabaseHelper database;
    Button btnSignup;
    EditText username, password, repass, code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repass = findViewById(R.id.password2);
        code = findViewById(R.id.code);
        btnSignup = findViewById(R.id.button);
        addCustomer();
    }

    public void addCustomer() {
        btnSignup.setOnClickListener(view -> {
            String sUsername = username.getText().toString();
            String sPassword = password.getText().toString();
            String sRepass = repass.getText().toString();
            String sCode = code.getText().toString();
            if (sUsername.equals("") || sPassword.equals("") || sRepass.equals("") || sCode.equals("")) {
                Toast.makeText(SignUp.this, "Please fill in all the fields", Toast.LENGTH_LONG).show();
            } else {
                if (sPassword.equals(sRepass)) {
                    Boolean checkUser = database.checkUsername(sUsername);
                    if (checkUser == false) {
                        Boolean insert = database.insertData(sUsername, sPassword);
                        if (insert == true) {
                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "User already exists", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
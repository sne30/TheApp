package com.example.theapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    TextView signuplink;
    Button loginbutton;
    TextInputEditText username;
    EditText password;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        signuplink = findViewById(R.id.signuplink);
        loginbutton = findViewById(R.id.loginbutton);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        DB = new DBHelper(this);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();
                if (USERNAME.equals(" ")||PASSWORD.equals(""))
                    Toast.makeText(MainActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkusernamepassword = DB.checkusernamepassword(USERNAME,PASSWORD);
                        if (checkusernamepassword==true){
                            Toast.makeText(MainActivity2.this, "Log in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity2.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
               signuplink.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    Toast.makeText(MainActivity2.this, "Sign Up Process", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
            }
        });
    }
}
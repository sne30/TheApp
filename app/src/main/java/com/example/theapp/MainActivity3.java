package com.example.theapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
public class MainActivity3 extends AppCompatActivity {
    Button button3;
    TextInputEditText username2;
    EditText password2 , reenter;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

            button3 = findViewById(R.id.button3);
//            name = findViewById(R.id.name);
            username2 = findViewById(R.id.username2);
            password2 =findViewById(R.id.password2);
            reenter = findViewById(R.id.reenter);
            DB = new DBHelper(this);

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    String NAME = name.getText().toString();
                    String USERNAME = username2.getText().toString();
                    String PASSWORD = password2.getText().toString();
                    String REENTER = reenter.getText().toString();

                    if (USERNAME.equals(" ") || PASSWORD.equals(" ") || REENTER.equals("")) {
                        Toast.makeText(MainActivity3.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    }else{
                        if (PASSWORD.equals(REENTER)) {
                            Boolean checkuser = DB.checkusername (USERNAME);

                            if (checkuser == false) {
                                Boolean insert = DB.insertdata (USERNAME, PASSWORD);

                                if (insert == true) {
                                    Toast.makeText(MainActivity3.this, "Registration Succesful.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                                    startActivity(intent);

                            } else{
                                    Toast.makeText(MainActivity3.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity3.this, "User already exists.\n Please Sign In", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity3.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            });

        }
    }

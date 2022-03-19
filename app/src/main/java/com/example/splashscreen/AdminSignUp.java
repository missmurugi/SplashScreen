package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminSignUp extends AppCompatActivity {

    EditText edtadmnamesignup,edtadmmailsignup,edtadmpasssignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        Button signupbtnadm = (Button) findViewById(R.id.signupbtnadm);
        edtadmnamesignup = (EditText) findViewById(R.id.edtadmnamesignup);
        edtadmmailsignup = (EditText) findViewById(R.id.edtadmmailsignup);
        edtadmpasssignup = (EditText) findViewById(R.id.edtadmpasssignup);

        signupbtnadm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String adminsignupname = edtadmnamesignup.getText().toString();
                String adminsignupmail = edtadmmailsignup.getText().toString();
                String adminsignuppass = edtadmpasssignup.getText().toString();
                if(adminsignupname.isEmpty()){
                    Toast.makeText(AdminSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(adminsignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(AdminSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(adminsignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(AdminSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(AdminSignUp.this, Admin.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    }


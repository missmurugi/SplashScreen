package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DriverSignUp extends AppCompatActivity {

    EditText edtdrivernamesignup,edtdrivermailsignup,edtdriverpasssignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_up);

        Button signupbtndriver = (Button) findViewById(R.id.signupbtndriver);
        edtdrivernamesignup = (EditText) findViewById(R.id.edtdrivernamesignup);
        edtdrivermailsignup = (EditText) findViewById(R.id.edtdrivermailsignup);
        edtdriverpasssignup = (EditText) findViewById(R.id.edtdriverpasssignup);

        signupbtndriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String driversignupname = edtdrivernamesignup.getText().toString();
                String driversignupmail = edtdrivermailsignup.getText().toString();
                String driversignuppass = edtdriverpasssignup.getText().toString();
                if(driversignupname.isEmpty()){
                    Toast.makeText(DriverSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(driversignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(DriverSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(driversignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(DriverSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(DriverSignUp.this, Driver.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
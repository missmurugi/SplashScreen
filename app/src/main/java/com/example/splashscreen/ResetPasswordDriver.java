package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordDriver extends AppCompatActivity  {

    EditText edtdriverpreviouspass,edtdrivercurrentpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_driver);

        Button btndriverreset = (Button) findViewById(R.id.btndriverreset);
        edtdriverpreviouspass = (EditText) findViewById(R.id.edtdriverpreviouspass);
        edtdrivercurrentpass = (EditText) findViewById(R.id.edtdrivercurrentpass);


        btndriverreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String driverprevious = edtdriverpreviouspass.getText().toString();
                String drivercurrent = edtdrivercurrentpass.getText().toString();

                if(driverprevious.isEmpty()){
                    Toast.makeText(ResetPasswordDriver.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(drivercurrent.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ResetPasswordDriver.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ResetPasswordDriver.this, Driver.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}
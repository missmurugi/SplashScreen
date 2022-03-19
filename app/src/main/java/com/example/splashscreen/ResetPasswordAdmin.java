package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordAdmin extends AppCompatActivity {

    EditText edtadmpreviouspass,edtadmcurrentpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_admin);

        Button btnadmreset = (Button) findViewById(R.id.btnadmreset);
        edtadmpreviouspass = (EditText) findViewById(R.id.edtadmpreviouspass);
        edtadmcurrentpass = (EditText) findViewById(R.id.edtadmcurrentpass);

        btnadmreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String adminprevious = edtadmpreviouspass.getText().toString();
                String admincurrent = edtadmcurrentpass.getText().toString();

                if(adminprevious.isEmpty()){
                    Toast.makeText(ResetPasswordAdmin.this, "Enter Previous Password", Toast.LENGTH_SHORT).show();
                }
                else if(admincurrent.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ResetPasswordAdmin.this, "Enter Current Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ResetPasswordAdmin.this, Admin.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    }

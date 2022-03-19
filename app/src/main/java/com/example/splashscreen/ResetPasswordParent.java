package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordParent extends AppCompatActivity  {

    EditText edtparentpreviouspass,edtparentcurrentpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_parent);

        Button btnparentreset = (Button) findViewById(R.id.signupbtnparent);
        edtparentpreviouspass = (EditText) findViewById(R.id.edtparentpreviouspass);
        edtparentcurrentpass = (EditText) findViewById(R.id.edtparentcurrentpass);

        btnparentreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String parentprevious = edtparentpreviouspass.getText().toString();
                String parentcurrent = edtparentcurrentpass.getText().toString();

                if(parentprevious.isEmpty()){
                    Toast.makeText(ResetPasswordParent.this, "Enter Previous Password", Toast.LENGTH_SHORT).show();
                }
                else if(parentcurrent.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ResetPasswordParent.this, "Enter Current Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ResetPasswordParent.this, Parent.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    }



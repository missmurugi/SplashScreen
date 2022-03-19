package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordHeadTeacher extends AppCompatActivity {

    EditText edtheadteacherpreviouspass,edtheadteachercurrentpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_head_teacher);


        Button btnheadteacherreset = (Button) findViewById(R.id.btnheadteacherreset);
        edtheadteacherpreviouspass = (EditText) findViewById(R.id.edtheadteacherpreviouspass);
        edtheadteachercurrentpass = (EditText) findViewById(R.id.edtheadteachercurrentpass);

        btnheadteacherreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String headteacherprevious = edtheadteacherpreviouspass.getText().toString();
                String headteachercurrent = edtheadteachercurrentpass.getText().toString();

                if(headteacherprevious.isEmpty()){
                    Toast.makeText(ResetPasswordHeadTeacher.this, "Enter Previous Password", Toast.LENGTH_SHORT).show();
                }
                else if(headteachercurrent.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ResetPasswordHeadTeacher.this, "Enter Current Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ResetPasswordHeadTeacher.this, HeadTeacher.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
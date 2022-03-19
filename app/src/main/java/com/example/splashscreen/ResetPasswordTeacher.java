package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordTeacher extends AppCompatActivity {

    EditText edtteacherpreviouspass,edtteachercurrentpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_teacher);

        Button btnteacherreset = (Button) findViewById(R.id.btnteacherreset);
        edtteacherpreviouspass = (EditText) findViewById(R.id.edtteacherpreviouspass);
        edtteachercurrentpass = (EditText) findViewById(R.id.edtteachercurrentpass);

        btnteacherreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String teacherprevious = edtteacherpreviouspass.getText().toString();
                String teachercurrent = edtteachercurrentpass.getText().toString();

                if(teacherprevious.isEmpty()){
                    Toast.makeText(ResetPasswordTeacher.this, "Enter Previous Password", Toast.LENGTH_SHORT).show();
                }
                else if(teachercurrent.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ResetPasswordTeacher.this, "Enter Current Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ResetPasswordTeacher.this, Teacher.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
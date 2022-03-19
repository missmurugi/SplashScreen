package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HeadTeacherSignUp extends AppCompatActivity {

    EditText edtheadteachernamesignup,edtheadteachermailsignup,edtheadteacherpasssignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_teacher_sign_up);

        Button signupbtnheadteacher = (Button) findViewById(R.id.signupbtnheadteacher);
        edtheadteachernamesignup = (EditText) findViewById(R.id.edtheadteachernamesignup);
        edtheadteachermailsignup = (EditText) findViewById(R.id.edtheadteachermailsignup);
        edtheadteacherpasssignup = (EditText) findViewById(R.id.edtheadteacherpasssignup);

        signupbtnheadteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String headteachersignupname = edtheadteachernamesignup.getText().toString();
                String headteachersignupmail = edtheadteachermailsignup.getText().toString();
                String headteachersignuppass = edtheadteacherpasssignup.getText().toString();
                if(headteachersignupname.isEmpty()){
                    Toast.makeText(HeadTeacherSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(headteachersignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(HeadTeacherSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(headteachersignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(HeadTeacherSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(HeadTeacherSignUp.this, HeadTeacher.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
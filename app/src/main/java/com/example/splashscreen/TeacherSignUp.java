package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherSignUp extends AppCompatActivity {

    EditText edtteachernamesignup,edtteachermailsignup,edtteacherpasssignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);

        Button signupbtnteacher = (Button) findViewById(R.id.signupbtnteacher);
        edtteachernamesignup = (EditText) findViewById(R.id.edtteachernamesignup);
        edtteachermailsignup = (EditText) findViewById(R.id.edtteachermailsignup);
        edtteacherpasssignup = (EditText) findViewById(R.id.edtteacherpasssignup);

        signupbtnteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String teachersignupname = edtteachernamesignup.getText().toString();
                String teachersignupmail = edtteachermailsignup.getText().toString();
                String teachersignuppass = edtteacherpasssignup.getText().toString();
                if(teachersignupname.isEmpty()){
                    Toast.makeText(TeacherSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(teachersignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(TeacherSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(teachersignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(TeacherSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(TeacherSignUp.this, Teacher.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
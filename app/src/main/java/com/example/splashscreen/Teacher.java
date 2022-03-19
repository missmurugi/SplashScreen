package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Teacher extends AppCompatActivity {

    EditText edtteachername,edtteacherpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        Button teacherlogin = (Button) findViewById(R.id.teacherlogin);
        edtteachername = (EditText) findViewById(R.id.edtteachername);
        edtteacherpass = (EditText) findViewById(R.id.edtteacherpass);
        TextView tvteachersignup = (TextView) findViewById(R.id.tvteachersignup);
        TextView tvteacherforgot = (TextView) findViewById(R.id.tvteacherforgot);

        teacherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String classteachername = edtteachername.getText().toString();
                String classteacherpass = edtteacherpass.getText().toString();

                boolean check = validateInfo(classteachername,classteacherpass);
                if (check==true){
                    //Intent intent = new Intent(Teacher.this, DashboardTeacher.class);
                    //startActivity(intent);
                    //finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Sorry Check Info again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvteachersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher.this, TeacherSignUp.class);
                startActivity(intent);
                finish();
            }
        });

        tvteacherforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher.this, ResetPasswordTeacher.class);
                startActivity(intent);
                finish();
            }
        });
        }
        private Boolean validateInfo(String classteachername, String classteacherpass) {
            if (classteachername.length()==0){
                edtteachername.requestFocus();
                edtteachername.setError("Field cannot be empty");
                return false;
            }else if (!classteachername.matches("[a-zA]+")){
                edtteachername.requestFocus();
                edtteachername.setError("Enter Aplhabets Only!!");
                return false;
            }else if (classteacherpass.length()==0){
                edtteacherpass.requestFocus();
                edtteacherpass.setError("Field cannot be empty");
                return false;
            }else if (classteacherpass.length()<=5){
                edtteacherpass.requestFocus();
                edtteacherpass.setError("Minimum 6 Characters Required!!");
                return false;
            }else{
                return  true;
            }
    }
    }

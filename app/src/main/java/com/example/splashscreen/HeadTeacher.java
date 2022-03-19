package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HeadTeacher extends AppCompatActivity {

    EditText edtheadteachername,edtheadteacherpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_teacher);

        Button headteacherlogin = (Button) findViewById(R.id.headteacherlogin);
        edtheadteachername = (EditText) findViewById(R.id.edtheadteachername);
        edtheadteacherpass = (EditText) findViewById(R.id.edtheadteacherpass);
        TextView tvheadteachersignup = (TextView) findViewById(R.id.tvheadteachersignup);
        TextView tvheadteacherforgot = (TextView) findViewById(R.id.tvheadteacherforgot);

        headteacherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String headteachername = edtheadteachername.getText().toString();
                String headteacherpass = edtheadteacherpass.getText().toString();

                boolean check = validateInfo(headteachername,headteacherpass);
                if (check==true){
                    //Intent intent = new Intent(HeadTeacher.this, DashboardHeadTeacher.class);
                    //startActivity(intent);
                    //finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Sorry Check Info again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvheadteachersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadTeacher.this, HeadTeacherSignUp.class);
                startActivity(intent);
                finish();
            }
        });

        tvheadteacherforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadTeacher.this, ResetPasswordHeadTeacher.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private Boolean validateInfo(String headteachername, String headteacherpass) {
        if (headteachername.length() == 0) {
            edtheadteachername.requestFocus();
            edtheadteachername.setError("Field cannot be empty");
            return false;
        } else if (!headteachername.matches("[a-zA]+")) {
            edtheadteachername.requestFocus();
            edtheadteachername.setError("Enter Aplhabets Only!!");
            return false;
        } else if (headteacherpass.length() == 0) {
            edtheadteacherpass.requestFocus();
            edtheadteacherpass.setError("Field cannot be empty");
            return false;
        } else if (headteacherpass.length() <= 5) {
            edtheadteacherpass.requestFocus();
            edtheadteacherpass.setError("Minimum 6 Characters Required!!");
            return false;
        } else {
            return true;
        }
    }
}
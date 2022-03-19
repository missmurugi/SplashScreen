package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Parent extends AppCompatActivity  {

    EditText edtparentname,edtparentpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parent);

        Button parentlogin = (Button) findViewById(R.id.parentlogin);
        edtparentname = (EditText) findViewById(R.id.edtparentname);
        edtparentpass = (EditText) findViewById(R.id.edtparentpass);
        TextView tvparentsignup = (TextView) findViewById(R.id.tvparentsignup);
        TextView tvparentforgot = (TextView) findViewById(R.id.tvparentforgot);

        parentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String parentname = edtparentname.getText().toString();
                String parentpass = edtparentpass.getText().toString();

                boolean check = validateInfo(parentname,parentpass);
                if (check==true){
                    //Intent intent = new Intent(Parent.this, DashboardParent.class);
                    //startActivity(intent);
                    //finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Sorry Check Info again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvparentsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parent.this, ParentSignUp.class);
                startActivity(intent);
                finish();
            }
        });

        tvparentforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Parent.this, ResetPasswordParent.class);
                //startActivity(intent);
                //finish();
            }
        });
    }

    private Boolean validateInfo(String parentname, String parentpass) {
        if (parentname.length()==0){
            edtparentname.requestFocus();
            edtparentname.setError("Field cannot be empty");
            return false;
        }else if (!parentname.matches("[a-zA]+")){
            edtparentname.requestFocus();
            edtparentname.setError("Enter Aplhabets Only!!");
            return false;
        }else if (parentpass.length()==0){
            edtparentpass.requestFocus();
            edtparentpass.setError("Field cannot be empty");
            return false;
        }else if (parentpass.length()<=5){
            edtparentpass.requestFocus();
            edtparentpass.setError("Minimum 6 Characters Required!!");
            return false;
        }else{
            return  true;
        }
    }

    }

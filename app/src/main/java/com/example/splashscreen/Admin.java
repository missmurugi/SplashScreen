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

import org.w3c.dom.Text;

public class Admin extends AppCompatActivity  {

    EditText edtadmname,edtadmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin);

        Button admlogin = (Button) findViewById(R.id.admlogin);
        edtadmname = (EditText) findViewById(R.id.edtadmname);
        edtadmpass = (EditText) findViewById(R.id.edtadmpass);
        TextView tvadmsignup = (TextView) findViewById(R.id.tvadmsignup);
        TextView tvadmforgot = (TextView) findViewById(R.id.tvadmforgot);

        admlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String adminname = edtadmname.getText().toString();
                String adminpass = edtadmpass.getText().toString();
                
                boolean check = validateInfo(adminpass,adminname);
                if (check ==true){
                    //Intent intent = new Intent(Admin.this, DashboardAdmin.class);
                    //startActivity(intent);
                    //finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Sorry Check Info again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvadmsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AdminSignUp.class);
                startActivity(intent);
                finish();
            }
        });

        tvadmforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, ResetPasswordAdmin.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private Boolean validateInfo(String adminpass, String adminname) {
        if (adminname.length()==0){
            edtadmname.requestFocus();
            edtadmname.setError("Field cannot be empty");
            return false;
        }else if (!adminname.matches("[a-zA]+")){
            edtadmname.requestFocus();
            edtadmname.setError("Enter Aplhabets Only!!");
            return false;
        }else if (adminpass.length()==0){
            edtadmpass.requestFocus();
            edtadmpass.setError("Field cannot be empty");
            return false;
        }else if (adminpass.length()<=5){
            edtadmpass.requestFocus();
            edtadmpass.setError("Minimum 6 Characters Required!!");
            return false;
        }else{
            return  true;
        }
    }
}
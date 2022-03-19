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

public class Driver extends AppCompatActivity  {

    EditText edtdrivername,edtdriverpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_driver);

        Button driverlogin = (Button) findViewById(R.id.driverlogin);
        edtdrivername = (EditText) findViewById(R.id.edtdrivername);
        edtdriverpass = (EditText) findViewById(R.id.edtdriverpass);
        TextView tvdriversignup = (TextView) findViewById(R.id.tvdriversignup);
        TextView tvdriverforgot = (TextView) findViewById(R.id.tvdriverforgot);


        driverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //Get all the values
                String drivername = edtdrivername.getText().toString();
                String driverpass = edtdriverpass.getText().toString();

                boolean check = validateInfo(drivername,driverpass);
                if (check==true){
                    //Intent intent = new Intent(Driver.this, DashboardDriver.class);
                    //startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(),"Sorry Check Info again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvdriversignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Driver.this, DriverSignUp.class);
                startActivity(intent);
                finish();
            }
        });

        tvdriverforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Driver.this, ResetPasswordDriver.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Boolean validateInfo(String drivername, String driverpass) {
        if (drivername.length()==0){
            edtdrivername.requestFocus();
            edtdrivername.setError("Field cannot be empty");
            return false;
        }else if (!drivername.matches("[a-zA]+")){
            edtdrivername.requestFocus();
            edtdrivername.setError("Enter Aplhabets Only!!");
            return false;
        }else if (driverpass.length()==0){
            edtdriverpass.requestFocus();
            edtdriverpass.setError("Field cannot be empty");
            return false;
        }else if (driverpass.length()<=5){
            edtdriverpass.requestFocus();
            edtdriverpass.setError("Minimum 6 Characters Required!!");
            return false;
        }else{
            return  true;
        }
    }

}



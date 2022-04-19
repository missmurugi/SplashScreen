package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.response_object.AdminResponseObject;
import com.example.splashscreen.services.EndPoints;
import com.example.splashscreen.services.Repository;
import com.example.splashscreen.services.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;

public class AdminSignUp extends AppCompatActivity {


    private static final String TAG = "TAG";
    EditText edtadmnamesignup,edtadmmailsignup,edtadmpasssignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        Button signupbtnadm = (Button) findViewById(R.id.signupbtnadm);
        edtadmnamesignup = (EditText) findViewById(R.id.edtadmnamesignup);
        edtadmmailsignup = (EditText) findViewById(R.id.edtadmmailsignup);
        edtadmpasssignup = (EditText) findViewById(R.id.edtadmpasssignup);

        signupbtnadm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String adminsignupname = edtadmnamesignup.getText().toString();
                String adminsignupmail = edtadmmailsignup.getText().toString();
                String adminsignuppass = edtadmpasssignup.getText().toString();
                if(adminsignupname.isEmpty()){
                    Toast.makeText(AdminSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(adminsignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(AdminSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(adminsignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(AdminSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                // create admin
                createAdmin(
                        adminsignupname,
                        adminsignupmail,
                        adminsignuppass
                );
            }
        });
    }





    public void createAdmin(
            String name,
            String email,
            String password


            ) {

        Log.d(TAG, "createAdmin: "+"called");

        Repository repository = RetrofitClientInstance.getRetrofitInstance(EndPoints.BASE_URL).create(Repository.class);
        Call<AdminResponseObject> call = repository.createAdmin(
                name,
                email,
                password

                );
        call.enqueue(new Callback<AdminResponseObject>() {
            @Override
            public void onResponse(Call<AdminResponseObject> call, retrofit2.Response<AdminResponseObject> response) {
                Log.d(TAG, "onResponse: "+response);
                if (response.isSuccessful() && response.code() == 200) {

                    Intent intent = new Intent(AdminSignUp.this, Admin.class);
                    startActivity(intent);
                    finish();

                }else {

                    Toast.makeText(getBaseContext(), "Error! Check internet connection and try again... "+response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AdminResponseObject> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());

                System.out.println();
                Toast.makeText(getBaseContext(), "Error! Check internet connection and try again... "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }

        });

    }



    }// end class


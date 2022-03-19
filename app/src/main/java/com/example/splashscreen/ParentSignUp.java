package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParentSignUp extends AppCompatActivity {

    EditText edtparentnamesignup,edtparentmailsignup,edtparentpasssignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_sign_up);

        Button signupbtnparent = (Button) findViewById(R.id.signupbtnparent);
        edtparentnamesignup = (EditText) findViewById(R.id.edtparentnamesignup);
        edtparentmailsignup = (EditText) findViewById(R.id.edtparentmailsignup);
        edtparentpasssignup = (EditText) findViewById(R.id.edtparentpasssignup);

        signupbtnparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values
                String parentsignupname = edtparentnamesignup.getText().toString();
                String parentsignupmail = edtparentmailsignup.getText().toString();
                String parentsignuppass = edtparentpasssignup.getText().toString();
                if(parentsignupname.isEmpty()){
                    Toast.makeText(ParentSignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(parentsignupmail.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ParentSignUp.this, "Enter e-mail", Toast.LENGTH_SHORT).show();
                }
                else if(parentsignuppass.isEmpty()){
                    // If name or password is not entered
                    Toast.makeText(ParentSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ParentSignUp.this, Parent.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    }



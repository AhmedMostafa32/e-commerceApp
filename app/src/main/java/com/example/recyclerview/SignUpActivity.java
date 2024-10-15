package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.databinding.ActivityLoginBinding;
import com.example.recyclerview.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
DBHelper DB;
ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB= new DBHelper(this);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =binding.name.getText().toString();
                String pass =binding.password.getText().toString();
                String email =binding.emill.getText().toString();
                if (name.equals("")|| pass.equals("")|| email.equals(""))
                    Toast.makeText(SignUpActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();

                else{
                    Boolean checkuser=DB.checkuseremail(email);
                    if(checkuser==false){
                        Boolean insert= DB.insertData(email,pass,name);
                        if (insert==true){
                            ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                            progressDialog.setMessage("Loading..."); // Setting Message
                            progressDialog.setTitle("Connecting Please Wait..."); // Setting Title
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                            progressDialog.show(); // Display Progress Dialog
                            progressDialog.setCancelable(false);

                            new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        Thread.sleep(2500);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    progressDialog.dismiss();
                                }
                            }).start();
                            Toast.makeText(SignUpActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(SignUpActivity.this,"Registered failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(SignUpActivity.this,"user already exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("Loading..."); // Setting Message
                progressDialog.setTitle("Connecting Please Wait..."); // Setting Title
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(2500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();
                Intent i=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
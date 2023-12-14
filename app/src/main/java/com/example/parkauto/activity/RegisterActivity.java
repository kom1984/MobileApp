package com.example.parkauto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkauto.R;
import com.example.parkauto.entity.LoginResponse;
import com.example.parkauto.entity.UserEntity;
import com.example.parkauto.retrofit.RetrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextFirstname,editTextLastname,editTextEmailAddress,editTextPassword;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Register credentials to connect

        editTextFirstname = findViewById(R.id.editTextFirstname);
        editTextLastname = findViewById(R.id.editTextLastname);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);


        //Btn user registered
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextFirstname.getText().toString()) ||
                        TextUtils.isEmpty(editTextLastname.getText().toString()) ||
                        TextUtils.isEmpty(editTextEmailAddress.getText().toString()) ||
                        TextUtils.isEmpty(editTextPassword.getText().toString())
                ){
                    Toast.makeText(RegisterActivity.this, "Firstname/Lastname/Email/Password are required!!!", Toast.LENGTH_LONG).show();
                }else{
                    //Proceed register
                    register();
                }
            }
        });
    }

    private void register() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(editTextFirstname.getText().toString());
        userEntity.setLastname(editTextLastname.getText().toString());
        userEntity.setEmail(editTextLastname.getText().toString());
        userEntity.setPassword(editTextLastname.getText().toString());

        Call<LoginResponse> registerResponseCall = RetrofitLogin
                .getUserRepository().userRegister(userEntity);
        registerResponseCall.enqueue(
                new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                     if(response.isSuccessful())  {
                         Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_LONG).show();
                         //Redirect to Login Activity
                         LoginResponse loginResponse = response.body();
                         new Handler().postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 startActivity(new Intent(RegisterActivity.this,
                                         LoginActivity.class)
                                         .putExtra("data",loginResponse.getFirstname()));
                             }
                         },7000);
                     }else{
                         Toast.makeText(RegisterActivity.this, "Register Failed!!!", Toast.LENGTH_LONG).show();
                     }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Throwable"+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
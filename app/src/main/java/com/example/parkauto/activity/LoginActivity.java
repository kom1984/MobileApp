package com.example.parkauto.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkauto.R;
import com.example.parkauto.entity.LoginResponse;
import com.example.parkauto.entity.UserEntity;
import com.example.parkauto.retrofit.RetrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    EditText etEmailAddress,etPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Login credentials connect
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etPassword = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etEmailAddress.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())

                ){
                    Toast.makeText(LoginActivity.this, "Email/Password Required!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Proceed to login
                    login();
                }


            }
        });
        // No login credentials go to register
        TextView btn = findViewById(R.id.textViewSignup);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        startActivity(new Intent(LoginActivity.this,
                                RegisterActivity.class));
                    }
                }
        );

    }
    private void login(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(etEmailAddress.getText().toString());
        userEntity.setPassword(etPassword.getText().toString());

        Call<LoginResponse> loginResponseCall = RetrofitLogin.getUserRepository()
                .userLogin(userEntity);
loginResponseCall.enqueue(new Callback<LoginResponse>() {
    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if(response.isSuccessful()) {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_LONG).show();
            //Redirect to Dashboard Activity
            LoginResponse loginResponse = response.body();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class)
                        .putExtra("data",loginResponse.getFirstname())
                            .putExtra("data1",loginResponse.getLastname())
                            .putExtra("data2",loginResponse.getEmail()));
                }
            },700);
        }else{
            Toast.makeText(LoginActivity.this, "Login failled!!!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Toast.makeText(LoginActivity.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
        });
    }

}
package com.example.parkauto.repository;

import com.example.parkauto.entity.LoginResponse;
import com.example.parkauto.entity.UserEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRepository {
    @POST("/api/auth/signin")
    Call<LoginResponse> userLogin(@Body UserEntity userEntity);

    @POST("/api/auth/signup")
    Call<LoginResponse> userRegister(@Body UserEntity userEntity);
}

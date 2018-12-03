package com.example.javi.forniteuservice.ForniteStadistics.services;

import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteUser;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ForniteAPI {

    @Headers("TRN-Api-Key: d4630b9f-745c-4778-8f77-b9d98ea35a02")
    @GET("v1/profile/{platform}/{epic-nickname}")
    Observable<ForniteUser> getInfoFornite(@Path("platform") String platform , @Path("epic-nickname") String epic_nickname);


    static ForniteAPI Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(ForniteAPI.class);
    }
}
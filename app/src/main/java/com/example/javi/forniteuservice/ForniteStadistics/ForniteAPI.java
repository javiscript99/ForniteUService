package com.example.javi.forniteuservice.ForniteStadistics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ForniteAPI {

    @Headers("TRN-Api-Key: 3181e97d-6177-42ac-9c02-e61f5934dffd")
    @GET("v1/profile/{platform}/{epic-nickname}")
    Observable<Fornite> getInfoFornite(@Path("platform") String platform , @Path("epic-nickname") String epic_nickname);


    static ForniteAPI Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(ForniteAPI.class);
    }
}
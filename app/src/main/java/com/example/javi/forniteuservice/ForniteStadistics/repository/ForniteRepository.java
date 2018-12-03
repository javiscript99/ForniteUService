package com.example.javi.forniteuservice.ForniteStadistics.repository;

import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteUser;
import com.example.javi.forniteuservice.ForniteStadistics.services.ForniteAPI;
import io.reactivex.Observable;

public class ForniteRepository {

    private static volatile ForniteRepository ourInstance = new ForniteRepository();

    private ForniteAPI forniteApi = ForniteAPI.Factory();

    public Observable<ForniteUser> getInfoFornite(String platform, String epic_nickname){
        //return gerritAPI.loadChanges(status);
        return forniteApi.getInfoFornite(platform,epic_nickname);
    }


    public static ForniteRepository getInstance() {
        if (ourInstance == null) {
            synchronized (ForniteRepository.class) {
                if (ourInstance == null) {
                    ourInstance = new ForniteRepository();
                }
            }
        }
        return ourInstance;
    }




}
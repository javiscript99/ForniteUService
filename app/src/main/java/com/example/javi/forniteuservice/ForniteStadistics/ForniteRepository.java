package com.example.javi.forniteuservice.ForniteStadistics;

import java.util.List;

import io.reactivex.Observable;

public class ForniteRepository {

    private static volatile ForniteRepository ourInstance = new ForniteRepository();

    static ForniteRepository getInstance() {
        if (ourInstance == null) {
            synchronized (ForniteRepository.class) {
                if (ourInstance == null) {
                    ourInstance = new ForniteRepository();
                }
            }
        }
        return ourInstance;
    }

    private ForniteRepository() {
    }

    private ForniteAPI forniteApi = ForniteAPI.Factory();


    public Observable<Fornite> getInfoFornite(String platform, String epic_nickname){
        //return gerritAPI.loadChanges(status);
        return forniteApi.getInfoFornite(platform,epic_nickname);
    }

}
package com.example.javi.forniteuservice.ForniteStadistics.vistas;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteUser;
import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteData;
import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteDataDetails;
import com.example.javi.forniteuservice.ForniteStadistics.repository.ForniteRepository;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForniteViewModel extends ViewModel {

    private ForniteRepository forniteRepository = ForniteRepository.getInstance();
    public MutableLiveData<List<ForniteDataDetails>> dataFornite = new MutableLiveData<>();
    public List<ForniteDataDetails> dataList = new ArrayList<>();


    public void getData(String platform, String epic_nickname){

        forniteRepository.getInfoFornite(platform,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ForniteUser>() {


                    @Override
                    public void onNext(ForniteUser forniteObject) {
                        //liveData.postValue(forniteObjects);


                        if(forniteObject!=null) {
                            dataList.clear();
                            ForniteData data = forniteObject.getStats().getP9();

                            dataFornite.postValue(dataList);
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getScore());
                            dataList.add(data.getKills());
                        }
                    }

                    @Override
                    public void onSubscribe(Disposable j) {

                    }
                });
    }
}
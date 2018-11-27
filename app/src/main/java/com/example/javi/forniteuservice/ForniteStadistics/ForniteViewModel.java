package com.example.javi.forniteuservice.ForniteStadistics;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForniteViewModel extends ViewModel {

    private ForniteRepository jobsRepository = ForniteRepository.getInstance();
    public MutableLiveData<List<ForniteRank>> dataFornite = new MutableLiveData<>();
    public List<ForniteRank> dataList = new ArrayList<>();


    public void getData(String platform, String epic_nickname){

        jobsRepository.getInfoFornite(platform,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Fornite>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fornite forniteObject) {
                        //liveData.postValue(forniteObjects);
                        if(forniteObject!=null) {
                            dataList.clear();
                            ForniteScore data = forniteObject.getStats().getP2();
                            dataList.add(data.getScore());
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKills());
                            dataFornite.postValue(dataList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("FalloServicio","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
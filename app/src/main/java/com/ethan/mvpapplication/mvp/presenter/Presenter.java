package com.ethan.mvpapplication.mvp.presenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.ethan.mvpapplication.mvp.view.IView;
import com.ethan.mvpapplication.mvp.model.DataModel;
import com.ethan.mvpapplication.mvp.model.IModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter extends BasePresenter<IView> implements IPresenter {
    private IModel mModel;
    private String TAG = "Presenter";

    public Presenter(){
        this.mModel = new DataModel();
    }
    // onCreate
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.d(TAG, "-----------LifecycleObserver -- onCreate");
    }
    // onStart
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.d(TAG, "-----------LifecycleObserver -- onStart");
    }
    // onPause
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.d(TAG, "-----------LifecycleObserver -- onPause");
    }
    // onStop
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.d(TAG, "-----------LifecycleObserver -- onStop");
    }
    // onDestroy
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        Log.d(TAG, "-----------LifecycleObserver -- onDestroy");
    }

    @Override
    public void getData(String s) {
        Call<ResponseBody> call = this.mModel.getData(s);
        getView().onDataDownloading();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    getView().onDataSuccess(result);
                } catch (IOException e) {
                    e.printStackTrace();
                    getView().onDataError();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                getView().onDataError();
            }
        });
    }
}

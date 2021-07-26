package com.ethan.mvpapplication.mvp.presenter;

import com.ethan.mvpapplication.mvp.view.IView;
import com.ethan.mvpapplication.mvp.model.DataModel;
import com.ethan.mvpapplication.mvp.model.IModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter extends BasePresenter<IView> implements IPresenter{
    private IModel mModel;

    public Presenter(){
        this.mModel = new DataModel();
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

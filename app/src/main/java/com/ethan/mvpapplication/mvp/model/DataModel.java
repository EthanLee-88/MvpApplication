package com.ethan.mvpapplication.mvp.model;


import com.ethan.mvpapplication.mvp.retrofit.RetrofitInstance;
import com.ethan.mvpapplication.mvp.retrofit.RetrofitRequestInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class DataModel implements IModel{

    @Override
    public Call<ResponseBody> getData(String s) {

        Call<ResponseBody> call =  RetrofitInstance.getRetrofitInstance().create(RetrofitRequestInterface.class).getRequest(s);

        return call;
    }
}

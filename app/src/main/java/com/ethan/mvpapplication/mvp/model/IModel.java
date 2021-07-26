package com.ethan.mvpapplication.mvp.model;

import okhttp3.ResponseBody;
import retrofit2.Call;

public interface IModel {

    Call<ResponseBody> getData(String s);
}

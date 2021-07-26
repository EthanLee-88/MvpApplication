package com.ethan.mvpapplication.mvp.view;

public interface IView {

    void onDataSuccess(String s);

    void onDataError();

    void onDataDownloading();
}

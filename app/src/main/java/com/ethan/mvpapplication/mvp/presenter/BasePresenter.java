package com.ethan.mvpapplication.mvp.presenter;

import com.ethan.mvpapplication.mvp.view.IView;

public class BasePresenter<V extends IView>{

    private V mView;

    public void attach(V iView) {
        this.mView = iView;
    }

    public void detach() {
        this.mView = null;
    }

    public V getView() {
        return mView;
    }
}

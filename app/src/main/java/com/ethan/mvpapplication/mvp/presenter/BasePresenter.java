package com.ethan.mvpapplication.mvp.presenter;

import androidx.lifecycle.LifecycleObserver;

import com.ethan.mvpapplication.mvp.view.IView;
// 实现 LifecycleObserver
public class BasePresenter<V extends IView> implements LifecycleObserver {

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

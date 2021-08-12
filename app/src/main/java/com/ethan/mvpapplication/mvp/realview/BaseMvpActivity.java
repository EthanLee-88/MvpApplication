package com.ethan.mvpapplication.mvp.realview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ethan.mvpapplication.mvp.presenter.BasePresenter;
import com.ethan.mvpapplication.mvp.view.IView;

public abstract class BaseMvpActivity<P extends BasePresenter<IView>> extends AppCompatActivity implements IView {

    public P mPresenter;
    public P getPresenter() {
        return mPresenter;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        initView();
        initData();
        mPresenter = createP();
        mPresenter.attach(this);
        getLifecycle().addObserver(mPresenter);
    }
    protected abstract P createP();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
        getLifecycle().removeObserver(mPresenter);
    }
    abstract void setContentView();

    abstract void initView();

    abstract void initData();
}

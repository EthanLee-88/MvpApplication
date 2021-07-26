package com.ethan.mvpapplication.mvp.realview;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ethan.mvpapplication.R;
import com.ethan.mvpapplication.mvp.presenter.Presenter;

public class MvpDataActivity extends BaseMvpActivity<Presenter> {
    private static final String TAG = "MvpDataActivity";
    private TextView mvpText;

    @Override
    protected Presenter createP() {
        return new Presenter();
    }

    @Override
    void setContentView() {
        Log.d(TAG, "----------setContentView");
        setContentView(R.layout.activity_mvp);
    }

    @Override
    void initView() {
        Log.d(TAG, "-----------initView");
        mvpText = findViewById(R.id.id_mvp);
    }

    @Override
    void initData() {
        Log.d(TAG, "-----------initData");
        mvpText.setText("碧云天");
    }

    public void onClick(View view) {
        getPresenter().getData("");
    }

    @Override
    public void onDataSuccess(String s) {
        Log.d(TAG, "-----------onDataSuccess");
    }

    @Override
    public void onDataError() {
        Log.d(TAG, "-----------onDataError");
    }

    @Override
    public void onDataDownloading() {
        Log.d(TAG, "-----------onDataDownloading");
    }
}

package com.chiachen.myarchitecture.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chiachen.myarchitecture.base.BaesActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaesActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        mPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void openMainActivity() {
    }
}

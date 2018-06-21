package com.chiachen.myarchitecture.di.module.activity.splash;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.ui.splash.SplashActivity;
import com.chiachen.myarchitecture.ui.splash.SplashMvpPresenter;
import com.chiachen.myarchitecture.ui.splash.SplashMvpView;
import com.chiachen.myarchitecture.ui.splash.SplashPresenter;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public abstract class SplashModule {

    @Binds
    abstract SplashMvpView provideMainView(SplashActivity mainActivity);

    @Provides
    static SplashMvpPresenter<SplashMvpView> provideMainPresenter(
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable,
            DataManager dataManager) {
        return new SplashPresenter<>(schedulerProvider, compositeDisposable, dataManager);
    }
}

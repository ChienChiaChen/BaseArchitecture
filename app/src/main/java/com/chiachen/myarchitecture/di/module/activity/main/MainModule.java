package com.chiachen.myarchitecture.di.module.activity.main;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.ui.main.MainActivity;
import com.chiachen.myarchitecture.ui.main.MainMvpPresenter;
import com.chiachen.myarchitecture.ui.main.MainMvpView;
import com.chiachen.myarchitecture.ui.main.MainPresenter;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public abstract class MainModule {

    @Binds
    abstract MainMvpView provideMainView(MainActivity mainActivity);

    @Provides
    static MainMvpPresenter<MainMvpView> provideMainPresenter(
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable,
            DataManager dataManager) {
        return new MainPresenter<>(schedulerProvider, compositeDisposable, dataManager);
    }
}

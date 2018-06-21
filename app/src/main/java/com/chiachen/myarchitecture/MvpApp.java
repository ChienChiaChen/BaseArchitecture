package com.chiachen.myarchitecture;

import android.app.Activity;
import android.app.Application;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.di.component.DaggerApplicationComponent;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

public class MvpApp extends Application implements HasActivityInjector {

    @Inject
    DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        initDagger2();
    }

    private void initDagger2() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
}

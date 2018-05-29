package com.chiachen.myarchitecture;

import android.app.Application;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.di.component.ApplicationComponent;
import com.chiachen.myarchitecture.di.component.DaggerApplicationComponent;
import com.chiachen.myarchitecture.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(this))
                        .build();

        mApplicationComponent.inject(this);
    }

}
package com.chiachen.myarchitecture;

import android.app.Application;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.di.component.ApplicationComponent;
import com.chiachen.myarchitecture.di.component.DaggerApplicationComponent;
import com.chiachen.myarchitecture.di.module.ApplicationModule;
import com.chiachen.myarchitecture.di.module.NetModule;
import com.chiachen.myarchitecture.di.module.RoomModule;
import com.facebook.stetho.Stetho;

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
                        .roomModule(new RoomModule(this))
                        .netModule(new NetModule(this))
                        .build();

        mApplicationComponent.inject(this);
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

}

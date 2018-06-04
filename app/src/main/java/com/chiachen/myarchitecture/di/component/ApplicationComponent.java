package com.chiachen.myarchitecture.di.component;

import android.app.Application;
import android.content.Context;

import com.chiachen.myarchitecture.MvpApp;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.di.ApplicationContext;
import com.chiachen.myarchitecture.di.module.ApplicationModule;
import com.chiachen.myarchitecture.di.module.NetModule;
import com.chiachen.myarchitecture.di.module.RoomModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        RoomModule.class,
        NetModule.class
})
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
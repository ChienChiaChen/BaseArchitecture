package com.chiachen.myarchitecture.di.component;

import android.content.Context;

import com.chiachen.myarchitecture.MvpApp;
import com.chiachen.myarchitecture.di.module.ApplicationModule;
import com.chiachen.myarchitecture.di.module.NetModule;
import com.chiachen.myarchitecture.di.module.RoomModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class,
        RoomModule.class,
        NetModule.class
})
@Singleton
public interface ApplicationComponent extends AndroidInjector<MvpApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Context context);
        ApplicationComponent build();
    }

    void inject(Context context);
}

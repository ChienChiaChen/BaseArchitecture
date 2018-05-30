package com.chiachen.myarchitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.chiachen.myarchitecture.data.AppDataManager;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.network.ApiHelper;
import com.chiachen.myarchitecture.data.network.AppApiHelper;
import com.chiachen.myarchitecture.data.prefs.AppPreferencesHelper;
import com.chiachen.myarchitecture.data.prefs.PreferencesHelper;
import com.chiachen.myarchitecture.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }
}

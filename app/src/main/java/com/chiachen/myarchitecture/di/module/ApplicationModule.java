package com.chiachen.myarchitecture.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.chiachen.myarchitecture.MvpApp;
import com.chiachen.myarchitecture.data.AppDataManager;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.network.ApiHelper;
import com.chiachen.myarchitecture.data.network.AppApiHelper;
import com.chiachen.myarchitecture.data.prefs.AppPreferencesHelper;
import com.chiachen.myarchitecture.data.prefs.PreferencesHelper;
import com.chiachen.myarchitecture.utils.AppConstants;
import com.chiachen.myarchitecture.utils.rx.AppSchedulerProvider;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(MvpApp context, String prefFileName) {
        return context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
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

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    SchedulerProvider providechedulerProvider(AppSchedulerProvider appSchedulerProvider) {
        return appSchedulerProvider;
    }
}

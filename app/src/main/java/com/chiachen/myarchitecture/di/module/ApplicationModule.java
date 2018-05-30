package com.chiachen.myarchitecture.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.chiachen.myarchitecture.data.AppDataManager;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.db.AppDbHelper;
import com.chiachen.myarchitecture.data.db.DbConfiguration;
import com.chiachen.myarchitecture.data.db.DbHelper;
import com.chiachen.myarchitecture.data.db.LocalDB;
import com.chiachen.myarchitecture.data.db.user.UserDao;
import com.chiachen.myarchitecture.data.db.user.UserLocalRepository;
import com.chiachen.myarchitecture.data.db.user.UserLocalSource;
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
    LocalDB provideUserDao() {
        return Room.databaseBuilder(mApplication.getApplicationContext(), LocalDB.class, DbConfiguration.DB_NAME).build();
    }

    @Singleton
    @Provides
    UserDao providesProductDao(LocalDB localDB) {
        return localDB.userDao();
    }

    @Provides
    @Singleton
    UserLocalRepository provideUserLocalDao(UserDao userDao) {
        return new UserLocalSource(userDao);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
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

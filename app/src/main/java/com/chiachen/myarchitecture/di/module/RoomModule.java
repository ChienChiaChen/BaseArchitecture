package com.chiachen.myarchitecture.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.chiachen.myarchitecture.data.db.AppDbHelper;
import com.chiachen.myarchitecture.data.db.DbConfiguration;
import com.chiachen.myarchitecture.data.db.DbHelper;
import com.chiachen.myarchitecture.data.db.LocalDB;
import com.chiachen.myarchitecture.data.db.user.UserDao;
import com.chiachen.myarchitecture.data.db.user.UserLocalRepository;
import com.chiachen.myarchitecture.data.db.user.UserLocalSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jianjiacheng on 2018/05/30.
 */

@Module
public class RoomModule {

    private final Application mApplication;

    public RoomModule(Application application) {
        mApplication = application;
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
}

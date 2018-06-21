package com.chiachen.myarchitecture.data;

import com.chiachen.myarchitecture.data.db.DbHelper;
import com.chiachen.myarchitecture.data.db.user.User;
import com.chiachen.myarchitecture.data.network.ApiHelper;
import com.chiachen.myarchitecture.data.network.model.BlogResponse;
import com.chiachen.myarchitecture.data.network.model.OpenSourceResponse;
import com.chiachen.myarchitecture.data.prefs.PreferencesHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    @Inject
    DbHelper mDbHelper;

    @Inject
    ApiHelper mApiHelper;

    @Inject
    PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager() {
    }

    // DB
    @Override
    public void addUsers(List<User> items) {
        mDbHelper.addUsers(items);
    }

    @Override
    public void addUser(User user) {
        mDbHelper.addUser(user);
    }

    @Override
    public Observable<List<User>> getUsers() {
        return mDbHelper.getUsers();
    }

    // API
    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiHelper.getOpenSourceApiCall();
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }
}

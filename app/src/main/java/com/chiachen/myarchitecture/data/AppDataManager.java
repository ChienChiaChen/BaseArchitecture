package com.chiachen.myarchitecture.data;

import com.chiachen.myarchitecture.data.db.DbHelper;
import com.chiachen.myarchitecture.data.db.user.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

@Singleton
public class AppDataManager implements DataManager {

    @Inject
    DbHelper mDbHelper;

    @Inject
    public AppDataManager(DbHelper dbHelper) {
        mDbHelper = dbHelper;

    }

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
}

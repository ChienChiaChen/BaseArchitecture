package com.chiachen.myarchitecture.data.db;

import com.chiachen.myarchitecture.data.db.user.User;
import com.chiachen.myarchitecture.data.db.user.UserLocalRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    @Inject
    UserLocalRepository mUserLocalRepository;

    @Inject
    public AppDbHelper() {
    }

    @Override
    public void addUsers(List<User> users) {
        mUserLocalRepository.addUsers(users);
    }

    @Override
    public void addUser(User user) {
        mUserLocalRepository.addUser(user);
    }

    @Override
    public Observable<List<User>> getUsers() {
        return mUserLocalRepository.getUsers();
    }
}

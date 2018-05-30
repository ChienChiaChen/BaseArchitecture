package com.chiachen.myarchitecture.data.db.user;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class UserLocalSource implements UserLocalRepository {

    private UserDao mUserDao;

    @Inject
    public UserLocalSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public void addUsers(List<User> items) {
        mUserDao.insertUsers(items);
    }

    @Override
    public void addUser(User user) {
        mUserDao.insertUser(user);
    }

    @Override
    public Observable<List<User>> getUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return mUserDao.getUsers();
            }
        });
    }
}

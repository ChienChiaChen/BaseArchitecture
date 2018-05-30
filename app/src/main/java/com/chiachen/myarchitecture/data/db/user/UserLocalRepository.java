package com.chiachen.myarchitecture.data.db.user;

import java.util.List;

import io.reactivex.Observable;

public interface UserLocalRepository {
    void addUsers(List<User> users);
    void addUser(User user);
    Observable<List<User>> getUsers();
}

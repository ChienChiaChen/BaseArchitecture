package com.chiachen.myarchitecture.data.db.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.chiachen.myarchitecture.data.db.DbConfiguration;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(List<User> user);

    @Query(DbConfiguration.USER_SELECT_ALL)
    List<User> getUsers();
}

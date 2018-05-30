package com.chiachen.myarchitecture.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.chiachen.myarchitecture.data.db.user.User;
import com.chiachen.myarchitecture.data.db.user.UserDao;

/**
 * Created by jianjiacheng on 2018/05/30.
 */

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class LocalDB extends RoomDatabase {
    public abstract UserDao userDao();
}
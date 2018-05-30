package com.chiachen.myarchitecture.data.db.user;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.chiachen.myarchitecture.data.db.DbConfiguration;

/**
 * Created by jianjiacheng on 2018/05/30.
 */

@Entity(tableName = DbConfiguration.USERS_TABLE_NAME, indices = {@Index(value = {DbConfiguration.USER_NAME}, unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbConfiguration.USER_ID)
    private int mId;

    @ColumnInfo(name = DbConfiguration.USER_NAME)
    private String mName;

    @ColumnInfo(name = DbConfiguration.USER_EMAIL)
    private String mEmail;

    @ColumnInfo(name = DbConfiguration.USER_AVATAR)
    private String avatar;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}

package com.chiachen.myarchitecture.data.db;

/**
 * Created by jianjiacheng on 2018/05/17.
 */

public interface DbConfiguration {
    String DB_NAME = "MyDatabase";
    //==============================================================================================
    String USERS_TABLE_NAME = "Users";
    String USER_ID = "id";
    String USER_NAME = "name";
    String USER_EMAIL = "email";
    String USER_AVATAR = "avatar";
    String USER_SELECT_ALL = "SELECT * FROM " + DbConfiguration.USERS_TABLE_NAME;
    //==============================================================================================
}

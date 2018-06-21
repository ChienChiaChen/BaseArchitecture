package com.chiachen.myarchitecture.data.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    @Inject
    SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper() {
    }
}

package com.chiachen.myarchitecture.data;

import com.chiachen.myarchitecture.data.db.DbHelper;
import com.chiachen.myarchitecture.data.network.ApiHelper;
import com.chiachen.myarchitecture.data.prefs.PreferencesHelper;

/**
 * Created by jianjiacheng on 2018/05/29.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
}

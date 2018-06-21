package com.chiachen.myarchitecture.di.module.activity.feed;

import com.chiachen.myarchitecture.ui.feed.FeedActivity;

import dagger.Binds;
import dagger.Module;

/**
 * Created by jianjiacheng on 2018/6/21.
 */

@Module
public abstract class FeedModule {

    @Binds
    abstract FeedActivity provideMainView(FeedActivity feedActivity);

}
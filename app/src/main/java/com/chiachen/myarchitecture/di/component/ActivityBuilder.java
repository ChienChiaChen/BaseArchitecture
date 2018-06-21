package com.chiachen.myarchitecture.di.component;

import com.chiachen.myarchitecture.di.module.activity.feed.FeedModule;
import com.chiachen.myarchitecture.di.module.activity.feed.blog.BlogFragmentProvider;
import com.chiachen.myarchitecture.di.module.activity.main.MainModule;
import com.chiachen.myarchitecture.di.module.activity.splash.SplashModule;
import com.chiachen.myarchitecture.ui.feed.FeedActivity;
import com.chiachen.myarchitecture.ui.main.MainActivity;
import com.chiachen.myarchitecture.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity getMainActivity();

    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity getSplashActivity();

    @ContributesAndroidInjector(modules = {FeedModule.class, BlogFragmentProvider.class})
    abstract FeedActivity getFeedActivity();
}

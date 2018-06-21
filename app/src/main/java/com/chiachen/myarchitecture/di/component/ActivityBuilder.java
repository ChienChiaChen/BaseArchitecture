package com.chiachen.myarchitecture.di.component;

import com.chiachen.myarchitecture.di.module.activity.main.MainModule;
import com.chiachen.myarchitecture.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity getMainActivity();
}

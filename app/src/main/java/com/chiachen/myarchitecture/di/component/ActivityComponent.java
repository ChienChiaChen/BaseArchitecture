package com.chiachen.myarchitecture.di.component;

import com.chiachen.myarchitecture.di.PerActivity;
import com.chiachen.myarchitecture.di.module.ActivityModule;
import com.chiachen.myarchitecture.fragment.FragmentPage1;
import com.chiachen.myarchitecture.ui.main.MainActivity;
import com.chiachen.myarchitecture.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(SplashActivity activity);
    void inject(FragmentPage1 fragmentPage1);
}

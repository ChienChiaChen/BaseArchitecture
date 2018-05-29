/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.chiachen.myarchitecture.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.chiachen.myarchitecture.di.ActivityContext;
import com.chiachen.myarchitecture.di.PerActivity;
import com.chiachen.myarchitecture.ui.splash.SplashMvpPresenter;
import com.chiachen.myarchitecture.ui.splash.SplashMvpView;
import com.chiachen.myarchitecture.ui.splash.SplashPresenter;
import com.chiachen.myarchitecture.utils.rx.AppSchedulerProvider;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
}

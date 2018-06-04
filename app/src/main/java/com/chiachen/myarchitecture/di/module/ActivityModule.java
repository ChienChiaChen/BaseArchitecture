package com.chiachen.myarchitecture.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.chiachen.myarchitecture.di.ActivityContext;
import com.chiachen.myarchitecture.di.PerActivity;
import com.chiachen.myarchitecture.ui.blog.BlogMvpPresenter;
import com.chiachen.myarchitecture.ui.blog.BlogPresenter;
import com.chiachen.myarchitecture.ui.feed.FeedPagerAdapter;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogAdapter;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogMvpView;
import com.chiachen.myarchitecture.ui.main.MainMvpPresenter;
import com.chiachen.myarchitecture.ui.main.MainMvpView;
import com.chiachen.myarchitecture.ui.main.MainPresenter;
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

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    // Blog fragment.
    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter();
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }
}

package com.chiachen.myarchitecture.di.module.activity.feed.blog;

import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.ui.blog.BlogMvpPresenter;
import com.chiachen.myarchitecture.ui.blog.BlogPresenter;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogFragment;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogMvpView;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by jianjiacheng on 2018/6/21.
 */

@Module
public abstract class BlogFragmentProvider {
    @ContributesAndroidInjector(modules = BlogFragmentModule.class)
    abstract BlogFragment provideBlogFragmentFactory();

    @Provides
    static BlogMvpPresenter<BlogMvpView> provideBlogPresenter(
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable,
            DataManager dataManager) {
        return new BlogPresenter<>(schedulerProvider, compositeDisposable, dataManager);
    }
}

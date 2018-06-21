package com.chiachen.myarchitecture.di.module.activity.feed.blog;

import com.chiachen.myarchitecture.ui.feed.blogs.BlogFragment;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogMvpView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mertsimsek on 02/06/2017.
 */
@Module
public class BlogFragmentModule {

    @Provides
    BlogMvpView provideDetailFragmentView(BlogFragment blogFragment){
        return blogFragment;
    }
}

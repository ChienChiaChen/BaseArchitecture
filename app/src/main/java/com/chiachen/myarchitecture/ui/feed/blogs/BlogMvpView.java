package com.chiachen.myarchitecture.ui.feed.blogs;

import com.chiachen.myarchitecture.base.BaseView;
import com.chiachen.myarchitecture.data.network.model.BlogResponse;

import java.util.List;


public interface BlogMvpView extends BaseView {
    void updateBlog(List<BlogResponse.Blog> blogList);
}

package com.chiachen.myarchitecture.ui.feed.blogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseFragment;
import com.chiachen.myarchitecture.data.network.model.BlogResponse;
import com.chiachen.myarchitecture.ui.blog.BlogMvpPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class BlogFragment extends BaseFragment implements BlogMvpView {

    public static final String TAG = "BlogFragment";

    private LinearLayoutManager mLinearLayoutManager;
    BlogAdapter mBlogAdapter;

    @Inject
    BlogMvpPresenter<BlogMvpView> mPresenter;

    @BindView(R.id.blog_recycler_view)
    RecyclerView mRecyclerView;

    public static Fragment newInstance() {
        return new BlogFragment();
    }

    @Override
    public void updateBlog(List<BlogResponse.Blog> blogList) {
        mBlogAdapter.addItems(blogList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        // adapter callback
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    protected void initUI(View view) {
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBlogAdapter = new BlogAdapter();
        mRecyclerView.setAdapter(mBlogAdapter);
        mPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

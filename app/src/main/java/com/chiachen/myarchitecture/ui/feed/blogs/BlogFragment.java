package com.chiachen.myarchitecture.ui.feed.blogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseFragment;
import com.chiachen.myarchitecture.di.component.ActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class BlogFragment extends BaseFragment implements BlogMvpView {

    public static final String TAG = "BlogFragment";

    public static Fragment newInstance() {
        return new BlogFragment();
    }

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        ActivityComponent component = getActivityComponent();
        if (null != component) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            // presenter
            // adapter callback
        }

        return view;
    }

    @Override
    protected void initUI(View view) {
    }
}

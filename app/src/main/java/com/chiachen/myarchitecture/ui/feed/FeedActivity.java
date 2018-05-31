package com.chiachen.myarchitecture.ui.feed;

import android.os.Bundle;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseActivity;

import butterknife.ButterKnife;

public class FeedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        initUI();
    }

    @Override
    protected void initUI() {

    }
}

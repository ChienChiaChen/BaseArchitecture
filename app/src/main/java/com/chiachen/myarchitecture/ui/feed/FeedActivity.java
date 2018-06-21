package com.chiachen.myarchitecture.ui.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseActivity;
import com.chiachen.myarchitecture.fragment.left.LeftFragment;
import com.chiachen.myarchitecture.fragment.right.RightFragment;
import com.chiachen.myarchitecture.ui.feed.blogs.BlogFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Inject
    FeedPagerAdapter mFeedPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        setUnBinder(ButterKnife.bind(this));
        initUI();
    }

    @Override
    protected void initUI() {
        setSupportActionBar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mFeedPagerAdapter.addFrag(LeftFragment.newInstance(), LeftFragment.TAG);
        mFeedPagerAdapter.addFrag(RightFragment.newInstance(), RightFragment.TAG);
        mFeedPagerAdapter.addFrag(BlogFragment.newInstance(), BlogFragment.TAG);
        mViewPager.setAdapter(mFeedPagerAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("Left"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Right"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Blog"));
        mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.holo_blue_bright));
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, FeedActivity.class);
        return intent;
    }
}

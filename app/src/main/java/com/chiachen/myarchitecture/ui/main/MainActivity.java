package com.chiachen.myarchitecture.ui.main;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseActivity;
import com.chiachen.myarchitecture.fragment.FragmentPage1;
import com.chiachen.myarchitecture.ui.custom.RoundedImageView;
import com.chiachen.myarchitecture.ui.feed.FeedActivity;
import com.chiachen.myarchitecture.utils.FragmentUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.drawer_view)
    DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onBackPressed() {
        if (mNavigationView.isShown()) {
            mDrawer.closeDrawer(GravityCompat.START);
            return;
        }

        if (0 != getSupportFragmentManager().getBackStackEntryCount()) {
            getSupportFragmentManager().popBackStackImmediate();
            if (0 == getSupportFragmentManager().getBackStackEntryCount()) unlockDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        initUI();
    }

    @Override
    protected void initUI() {
        setSupportActionBar(mToolbar);
        setActionBar();
        setNavMenu();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable)drawable).start();
        }

        switch (item.getItemId()) {
            case R.id.action_copy:
                showSnackBar("Copy");
                return true;
            case R.id.action_cut:
                showSnackBar("Cut");
                return true;
            case R.id.action_delete:
                showSnackBar("Delete");
                return true;
            case R.id.action_share:
                showSnackBar("Share");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setActionBar() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public void showFragment() {
        FragmentUtils.nextFragment(getSupportFragmentManager(), FragmentPage1.newInstance(), FragmentPage1.TAG, R.id.cl_root_view);
    }

    private TextView mNameTextView;
    private TextView mEmailTextView;
    private RoundedImageView mProfileImageView;

    private void setNavMenu() {
        View headerLayout = mNavigationView.getHeaderView(0);
        mProfileImageView = (RoundedImageView) headerLayout.findViewById(R.id.iv_profile_pic);
        mNameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onBackPressed();

                switch (item.getItemId()) {
                    case R.id.nav_item_about: {
                        mPresenter.onDrawerOptionAboutClick();
                        return true;
                    }
                    case R.id.nav_item_rate_us: {
                        return true;
                    }
                    case R.id.nav_item_feed: {
                        startActivity(FeedActivity.getStartIntent(MainActivity.this));
                        return true;
                    }
                    case R.id.nav_item_logout: {
                        return true;
                    }
                    default: return false;
                }
            }
        });
    }

    @Override
    public void lockDrawer() {
        if (null == mDrawer) return;
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void unlockDrawer() {
        if (null == mDrawer) return;
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
}

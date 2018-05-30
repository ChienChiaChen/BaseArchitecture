package com.chiachen.myarchitecture;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.chiachen.myarchitecture.base.BaesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaesActivity {

    @BindView(R.id.drawer_view)
    DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onBackPressed() {
        if (mNavigationView.isShown()){
            mDrawer.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));

        setSupportActionBar(mToolbar);
        setActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null) {
            // If User attach fragment, plz lock the drawer.
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
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
                this
                ,mDrawer,mToolbar,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }
}

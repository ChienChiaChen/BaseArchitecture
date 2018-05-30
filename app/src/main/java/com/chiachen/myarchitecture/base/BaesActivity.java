package com.chiachen.myarchitecture.base;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chiachen.myarchitecture.MvpApp;
import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.di.component.ActivityComponent;
import com.chiachen.myarchitecture.di.component.DaggerActivityComponent;
import com.chiachen.myarchitecture.di.module.ActivityModule;
import com.chiachen.myarchitecture.utils.CommonUtils;

import butterknife.Unbinder;

public class BaesActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog mProgressDialog;

    private ActivityComponent mActivityComponent;

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent =
                DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp)getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            showSnackBar(msg);
        } else {
            showSnackBar(getString(R.string.error_some));
        }
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMsg(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.error_some), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMsg(int resId) {
        showMsg(getString(resId));
    }

    @Override
    public boolean isNetworkedConnected() {
        return false;
    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.setDuration(Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}

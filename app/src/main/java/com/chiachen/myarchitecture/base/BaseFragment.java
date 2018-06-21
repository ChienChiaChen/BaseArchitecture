package com.chiachen.myarchitecture.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.chiachen.myarchitecture.utils.CommonUtils;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {
    private BaseActivity mActivity;
    private Unbinder mUnbinder;
    private ProgressDialog mProgressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if (null != mUnbinder) {
            mUnbinder = null;
        }
        super.onDestroy();
    }

    //==============================================================================================

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnbinder = unBinder;
    }

    protected abstract void initUI(View view);

    //==============================================================================================
    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getContext());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (null == mActivity) return;
        mActivity.onError(resId);
    }

    @Override
    public void onError(String msg) {
        if (null == mActivity) return;
        mActivity.onError(msg);

    }

    @Override
    public void showMsg(int resId) {
        if (null == mActivity) return;
        mActivity.showMsg(resId);

    }

    @Override
    public void showMsg(String msg) {
        if (null == mActivity) return;
        mActivity.showMsg(msg);
    }

    @Override
    public void showSnackBar(String msg) {
        if (null == mActivity) return;
        mActivity.showSnackBar(msg);
    }

    @Override
    public boolean isNetworkedConnected() {
        return false;
    }
}

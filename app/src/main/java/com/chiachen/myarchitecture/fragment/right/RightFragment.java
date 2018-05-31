package com.chiachen.myarchitecture.fragment.right;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseFragment;

/**
 * Created by jianjiacheng on 2018/05/31.
 */

public class RightFragment extends BaseFragment {
    public static final String TAG = "RightFragment";


    public static RightFragment newInstance() {
        return new RightFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    @Override
    protected void initUI(View view) {

    }
}

package com.chiachen.myarchitecture.fragment.left;

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

public class LeftFragment extends BaseFragment {

    public static final String TAG = "JASON_CHIEN";

    public static LeftFragment newInstance() {
        return new LeftFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        return view;
    }

    @Override
    protected void initUI(View view) {

    }
}

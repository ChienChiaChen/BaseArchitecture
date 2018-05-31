

package com.chiachen.myarchitecture.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiachen.myarchitecture.R;
import com.chiachen.myarchitecture.base.BaseFragment;
import com.chiachen.myarchitecture.di.component.ActivityComponent;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentPage1 extends BaseFragment {
    public static final String TAG = "FragmentPage1";

    @OnClick(R.id.nav_back_btn)
    void onNavBackClick(){
        getBaseActivity().onBackPressed();
    }

    public static FragmentPage1 newInstance() {
        return new FragmentPage1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_1, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
        }
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

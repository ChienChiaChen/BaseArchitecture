package com.chiachen.myarchitecture.ui.main;

import com.chiachen.myarchitecture.base.BasePresenterImpl;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenterImpl<V>  implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable,
                         DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDrawerOptionAboutClick() {
        getMvpView().lockDrawer();
        getMvpView().showFragment();
    }
}

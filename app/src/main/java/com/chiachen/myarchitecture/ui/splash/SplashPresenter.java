package com.chiachen.myarchitecture.ui.splash;

import com.chiachen.myarchitecture.base.BasePresenterImpl;
import com.chiachen.myarchitecture.data.DataManager;
import com.chiachen.myarchitecture.data.db.user.User;
import com.chiachen.myarchitecture.data.network.ApiCallback;
import com.chiachen.myarchitecture.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.bloco.faker.Faker;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenterImpl<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);

    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    public void loadData() {
        getMvpView().showLoading();
        addSubscription(
                Observable.create(new ObservableOnSubscribe<User>() {
                    @Override
                    public void subscribe(ObservableEmitter<User> e) throws Exception {
                        Faker faker = new Faker();
                        User user;
                        user = new User();
                        user.setEmail(faker.internet.email("JasonFromTaiwan"));
                        user.setName("JasonFromTaiwan");
                        user.setAvatar(faker.avatar.image(user.getEmail()));
                        e.onNext(user);
                        e.onComplete();
                    }
                }).doOnNext(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        getDataManager().addUser(user);
                    }
                }).delay(3, TimeUnit.SECONDS),
                new ApiCallback<User>() {
                    @Override
                    public void onSuccess(User integer) {
                    }

                    @Override
                    public void onFailure(String msg) {
                        getMvpView().onError(msg);
                    }

                    @Override
                    public void onFinish() {
                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();
                    }
                }
        );
    }
}

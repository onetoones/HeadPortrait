package com.example.headportrait.model;

import android.util.Log;

import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;
import com.example.headportrait.net.Api;
import com.example.headportrait.net.OkRetrofiter;
import com.example.headportrait.net.OnNetListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * @Creation date
 * @name
 * @Class action
 */

public class HeadModel implements IHeadModel {

    @Override
    public void getheads(MultipartBody.Part f, final OnNetListener<MyBean> onNetListener) {

        Observable<MyBean> head = OkRetrofiter.getApi(Api.HOST).head("3402", f);

        head.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean bean) {
                        onNetListener.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFaile((Exception) e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUser( final OnNetListener<UserBean> onNetListener) {
        Observable<UserBean> user = OkRetrofiter.getApi(Api.HOST).users("3402");
        user.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        onNetListener.onSuccess(userBean);
                        Log.e("userBean++=======",userBean.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFaile((Exception) e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

package com.example.headportrait.presenter;

import android.util.Log;

import com.example.headportrait.base.BasePresenter;
import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;
import com.example.headportrait.model.HeadModel;
import com.example.headportrait.model.IHeadModel;
import com.example.headportrait.net.OnNetListener;
import com.example.headportrait.view.IView;

import okhttp3.MultipartBody;

/**
 * @Creation date
 * @name
 * @Class action
 */

public class HeadPresenter extends BasePresenter<IView> {
    private IHeadModel model = new HeadModel();
    private IView activity;

    public void getaa(MultipartBody.Part file) {

        activity = getThis();

        model.getheads(file, new OnNetListener<MyBean>() {

            @Override
            public void onSuccess(MyBean bean) {
                if (activity != null) {
                    activity.show(bean);
                }
            }

            @Override
            public void onFaile(Exception e) {

            }
        });

    }

    public void getusers() {

        model.getUser(new OnNetListener<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                Log.e("userBeanppppppp=======",userBean.getData().getUsername());
                if (activity!=null){
                    activity.usera(userBean);
                }

            }

            @Override
            public void onFaile(Exception e) {

            }
        });
    }

}

package com.example.headportrait.model;

import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;
import com.example.headportrait.net.OnNetListener;

import okhttp3.MultipartBody;

/**
 * @Creation date
 * @name
 * @Class action
 */

public interface IHeadModel {

void getheads(MultipartBody.Part f, OnNetListener<MyBean> onNetListener);
    void getUser(OnNetListener<UserBean> onNetListener);
}



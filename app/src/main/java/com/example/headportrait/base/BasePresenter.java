package com.example.headportrait.base;

/**
 * @Creation date
 * @name
 * @Class action
 */

public class BasePresenter<T extends BaseView> {
    T t;

    public void BasePresenter(T t) {
        this.t = t;
    }

    public void onDestroys() {
        t = null;
    }
public T getThis(){
     return t;
}
}

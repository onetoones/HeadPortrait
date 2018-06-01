package com.example.headportrait.view;

import com.example.headportrait.base.BaseView;
import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;

/**
 * @Creation date
 * @name
 * @Class action
 */

public interface IView extends BaseView{
    public void show(MyBean bb);
    void usera(UserBean bean);
}

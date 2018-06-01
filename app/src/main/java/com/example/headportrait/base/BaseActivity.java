package com.example.headportrait.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.headportrait.R;

import butterknife.ButterKnife;

/**
 * @Creation date
 * @name
 * @Class action
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        presenter = getPresenter();

        if (presenter != null) {
            presenter.BasePresenter(this);
        }
        initData();
        initView();
    }

    protected abstract void initView();

    protected abstract P getPresenter();

    protected abstract void initData();

    protected abstract int setLayout();
}

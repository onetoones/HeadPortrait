package com.example.headportrait;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Creation date
 * @name
 * @Class action
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

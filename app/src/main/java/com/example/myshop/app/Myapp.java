package com.example.myshop.app;

import android.app.Application;
import android.content.Context;

import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
    }

}

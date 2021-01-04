package com.example.myshop.app;

import android.app.Application;
import android.content.Context;

import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class Myapp extends Application {
    public static Myapp app;
    public static HashMap<String,Object> map;
    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
        app = this;
        map=new HashMap<>();
    }

    public static Myapp getInstance() {
        return app;
    }

    private static Context mAppContext = null;

    public static HashMap<String, Object> getMap() {
        return map;
    }


}

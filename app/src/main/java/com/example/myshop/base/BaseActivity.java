package com.example.myshop.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements BaseView{

    public P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (persenter == null) {
            createPersneter();
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();
    public void createPersneter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class<P> p = (Class<P>) typeArguments[0];
        try {
            persenter = p.newInstance();
            persenter.attrchView(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.detachView();
        }
    }
}

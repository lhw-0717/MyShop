package com.example.myshop.net;

public interface INteCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}

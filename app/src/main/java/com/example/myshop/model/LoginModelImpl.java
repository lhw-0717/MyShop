package com.example.myshop.model;

import com.example.myshop.contract.LoginContract;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.RetrofitUtils;

import java.util.HashMap;

public class LoginModelImpl implements LoginContract.ILoginModel {
    @Override
    public <T> void getModel(String url, HashMap<String, String> hashMap, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().post(url,hashMap,callBack);
    }
}

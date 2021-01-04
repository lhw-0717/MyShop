package com.example.myshop.model;

import com.example.myshop.contract.LoginStartContract;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.RetrofitUtils;

import java.util.HashMap;

public class LoginStartModelImpl implements LoginStartContract.ILoginStartModel {

    @Override
    public <T> void refreshToken(String url, HashMap<String, String> headers, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().post(url,null,callBack);
    }
}

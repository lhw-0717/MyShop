package com.example.myshop.model;

import com.example.myshop.contract.Knowladge2Contract;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.RetrofitUtils;

public class Knowladge2ModelImpl implements Knowladge2Contract.Knowladge2Model {

    @Override
    public <T> void getMod(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}

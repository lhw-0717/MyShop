package com.example.myshop.model;

import com.example.myshop.contract.KnowladgeContract;
import com.example.myshop.contract.MainContract;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.RetrofitUtils;

public class KnowladgeModelImpl implements KnowladgeContract.KnowladgeModel {

    @Override
    public <T> void getMod(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}

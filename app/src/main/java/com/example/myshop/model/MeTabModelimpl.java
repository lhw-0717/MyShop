package com.example.myshop.model;

import com.example.myshop.contract.MeContract;
import com.example.myshop.contract.MeTabContract;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.RetrofitUtils;

public class MeTabModelimpl implements MeTabContract.MeTabModel {
    @Override
    public <T> void getMod(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}

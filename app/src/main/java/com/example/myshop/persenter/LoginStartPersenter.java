package com.example.myshop.persenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.TokenBean;
import com.example.myshop.contract.LoginStartContract;
import com.example.myshop.model.LoginStartModelImpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class LoginStartPersenter extends BasePersenter<LoginStartContract.ILoginStartView, LoginStartContract.ILoginStartModel> implements LoginStartContract.ILoginStartPersenter {
    @Override
    protected LoginStartContract.ILoginStartModel getModel() {
        return new LoginStartModelImpl();
    }

    @Override
    public void refreshToken() {
        MMKV mmkv = MMKV.defaultMMKV();
        if (!TextUtils.isEmpty(mmkv.decodeString("token"))) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("X-Nideshop-Token", mmkv.decodeString("token"));
            iModel.refreshToken(URLConstant.TOKEN,hashMap,new INteCallBack<TokenBean>() {
                @Override
                public void onSuccess(TokenBean tokenBean) {
                    mmkv.encode("token",tokenBean.getData());
                }

                @Override
                public void onFail(String err) {
                    Log.e("TAG", "onFail: "+err );
                }
            });
        }
    }

}

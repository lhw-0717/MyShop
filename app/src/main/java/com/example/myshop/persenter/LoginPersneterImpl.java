package com.example.myshop.persenter;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.LoginBean;
import com.example.myshop.contract.LoginContract;
import com.example.myshop.model.LoginModelImpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class LoginPersneterImpl extends BasePersenter<LoginContract.ILoginView, LoginContract.ILoginModel> implements LoginContract.ILoginPersenter {
    @Override
    protected LoginContract.ILoginModel getModel() {
        return new LoginModelImpl();
    }

    @Override
    public void per(String username,String password) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username",username);
        hashMap.put("password",password);
        iModel.getModel(URLConstant.LOGIN, hashMap, new INteCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean.getData().getCode()==200) {
                    MMKV mmkv = MMKV.defaultMMKV();
                    mmkv.encode("token", loginBean.getData().getToken());
                    mmkv.encode("uid", loginBean.getData().getUserInfo().getUid());
                    mmkv.encode("username", loginBean.getData().getUserInfo().getUsername());
                    mmkv.encode("nickname", loginBean.getData().getUserInfo().getNickname());
                    mmkv.encode("gender", loginBean.getData().getUserInfo().getGender());
                    mmkv.encode("avatar", loginBean.getData().getUserInfo().getAvatar());
                    mmkv.encode("birthday", loginBean.getData().getUserInfo().getBirthday());
                    iView.loginSuccess();
                }else {
                    iView.loginFail();
                }

            }

            @Override
            public void onFail(String err) {
                iView.loginFail();
            }
        });
    }
}

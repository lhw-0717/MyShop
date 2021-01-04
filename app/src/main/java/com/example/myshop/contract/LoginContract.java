package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.net.INteCallBack;

import java.util.HashMap;

public class LoginContract {
    public interface ILoginView extends BaseView {
        String getUserName();
        String getPassWoerd();

        void loginSuccess();
        void loginFail();

    }

    public interface ILoginModel extends BaseModel {
        <T> void getModel(String url, HashMap<String,String> hashMap, INteCallBack<T> callBack);
    }

    public interface ILoginPersenter {
        void per(String username,String password);
    }
}

package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.net.INteCallBack;

import java.util.HashMap;

public class LoginStartContract {
    public interface ILoginStartView extends BaseView {
        void countDown();
    }

    public interface ILoginStartModel extends BaseModel{
        <T> void refreshToken(String url, HashMap<String, String> headers, INteCallBack<T> callBack);
    }

    public interface ILoginStartPersenter {
        void refreshToken();
    }
}

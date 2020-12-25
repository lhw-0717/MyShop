package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.net.INteCallBack;

public class MainContract {
    public interface MainModel extends BaseModel {
        <T>void getMod(String url, INteCallBack<T> callBack);
    }
    public interface MainPersenter{
        void per();
    }
    public interface MainView extends BaseView {
        void getData(HomeBean homeBean);
        void getResult(String string);
    }
}

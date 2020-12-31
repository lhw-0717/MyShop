package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.net.INteCallBack;

public class MeTabContract {
    public interface MeTabModel extends BaseModel {
        <T>void getMod(String url, INteCallBack<T> callBack);
    }
    public interface MeTabPersenter{
        void per(int id);
    }
    public interface MeTabView extends BaseView {
        void getData(MeTabBean tabBean);
        void getResult(String string);
    }
}

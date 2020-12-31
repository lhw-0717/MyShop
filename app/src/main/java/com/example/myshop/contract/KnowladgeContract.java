package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.net.INteCallBack;

public class KnowladgeContract {
    public interface KnowladgeModel extends BaseModel {
        <T>void getMod(String url, INteCallBack<T> callBack);
    }
    public interface KnowladgePersenter{
        void per();
    }
    public interface KnowladgeView extends BaseView {
        void getData(SpecialBean specialBean);
        void getResult(String string);
    }
}

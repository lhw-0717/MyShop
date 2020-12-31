package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.net.INteCallBack;

public class Knowladge2Contract {
    public interface Knowladge2Model extends BaseModel {
        <T>void getMod(String url, INteCallBack<T> callBack);
    }
    public interface Knowladge2Persenter{
        void per();
    }
    public interface Knowladge2View extends BaseView {
        void getData(SpecialBean specialBean);
        void getResult(String string);
    }
}

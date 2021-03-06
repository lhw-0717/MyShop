package com.example.myshop.contract;

import com.example.myshop.base.BaseModel;
import com.example.myshop.base.BaseView;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.net.INteCallBack;

public class MeContract {
    public interface MeModel extends BaseModel {
        <T>void getMod(String url, INteCallBack<T> callBack);
    }
    public interface MePersenter{
        void per();
    }
    public interface MeView extends BaseView {
        void getData(MeTabBean tabBean);
        void getResult(String string);
    }
}

package com.example.myshop.persenter;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.HomeBean;
import com.example.myshop.contract.MainContract;
import com.example.myshop.model.MainModelImpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;

public class MainPersenterImpl extends BasePersenter<MainContract.MainView, MainContract.MainModel> implements MainContract.MainPersenter {
    @Override
    protected MainContract.MainModel getModel() {
        return new MainModelImpl();
    }

    @Override
    public void per() {
        iModel.getMod(URLConstant.BASEURL, new INteCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                iView.getData(homeBean);
            }

            @Override
            public void onFail(String err) {
                iView.getResult("网络异常：" + err);
            }
        });
    }
}

package com.example.myshop.persenter;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.contract.Knowladge2Contract;
import com.example.myshop.contract.KnowladgeContract;
import com.example.myshop.model.Knowladge2ModelImpl;
import com.example.myshop.model.KnowladgeModelImpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;

public class Knowladge2Persenterimpl extends BasePersenter<Knowladge2Contract.Knowladge2View, Knowladge2Contract.Knowladge2Model> implements Knowladge2Contract.Knowladge2Persenter {
    @Override
    protected Knowladge2Contract.Knowladge2Model getModel() {
        return new Knowladge2ModelImpl();
    }

    @Override
    public void per() {
        iModel.getMod(URLConstant.SPECIAL2, new INteCallBack<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
                iView.getData(specialBean);
            }

            @Override
            public void onFail(String err) {
                iView.getResult(err);
            }
        });
    }
}

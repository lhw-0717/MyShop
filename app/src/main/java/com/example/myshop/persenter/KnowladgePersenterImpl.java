package com.example.myshop.persenter;

import android.telecom.Call;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.contract.KnowladgeContract;
import com.example.myshop.model.KnowladgeModelImpl;
import com.example.myshop.model.MainModelImpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;

public class KnowladgePersenterImpl extends BasePersenter<KnowladgeContract.KnowladgeView, KnowladgeContract.KnowladgeModel> implements KnowladgeContract.KnowladgePersenter {
    @Override
    protected KnowladgeContract.KnowladgeModel getModel() {
        return new KnowladgeModelImpl();
    }

    @Override
    public void per() {
        iModel.getMod(URLConstant.SPECIAL, new INteCallBack<SpecialBean>() {
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

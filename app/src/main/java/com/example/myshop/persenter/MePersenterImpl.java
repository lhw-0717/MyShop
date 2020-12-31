package com.example.myshop.persenter;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.contract.MeContract;
import com.example.myshop.model.MeModelimpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;

public class MePersenterImpl extends BasePersenter<MeContract.MeView, MeContract.MeModel> implements MeContract.MePersenter {
    @Override
    protected MeContract.MeModel getModel() {
        return new MeModelimpl();
    }

    @Override
    public void per() {
        iModel.getMod(URLConstant.INDEX, new INteCallBack<MeTabBean>() {
            @Override
            public void onSuccess(MeTabBean tabBean) {
                iView.getData(tabBean);
            }

            @Override
            public void onFail(String err) {
                iView.getResult(err);
            }
        });
    }
}

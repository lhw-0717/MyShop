package com.example.myshop.persenter;

import com.example.myshop.base.BasePersenter;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.contract.MeContract;
import com.example.myshop.contract.MeTabContract;
import com.example.myshop.model.MeModelimpl;
import com.example.myshop.model.MeTabModelimpl;
import com.example.myshop.net.INteCallBack;
import com.example.myshop.net.URLConstant;

public class MeTabPersenterImpl extends BasePersenter<MeTabContract.MeTabView, MeTabContract.MeTabModel> implements MeTabContract.MeTabPersenter {
    @Override
    protected MeTabContract.MeTabModel getModel() {
        return new MeTabModelimpl();
    }

    @Override
    public void per(int id) {
        iModel.getMod(URLConstant.CURRENT+"/?id="+id, new INteCallBack<MeTabBean>() {
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

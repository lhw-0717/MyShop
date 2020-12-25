package com.example.myshop.base;

public abstract class BasePersenter<V extends BaseView, M extends BaseModel> {


    public V iView;
    public M iModel;

    public void attrchView(V v) {
        iView = v;
        iModel = getModel();
    }
    public void detachView(){
        iView=null;
        iModel=null;
    }

    protected abstract M getModel();
}

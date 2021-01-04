package com.example.myshop.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myshop.contract.MainContract;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFrgment<P extends BasePersenter> extends Fragment implements BaseView {
    public P persenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        if (persenter == null) {
            createPersneter();
        }
        initView(inflate);
        initData();
        return inflate;
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract int getLayoutID();

    public void createPersneter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class<P> p = (Class<P>) typeArguments[0];
        try {
            persenter = p.newInstance();
            persenter.attrchView(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (persenter != null) {
            persenter.detachView();
        }
    }*/
}

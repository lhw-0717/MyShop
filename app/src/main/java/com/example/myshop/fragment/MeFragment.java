package com.example.myshop.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myshop.CustomViewPager;
import com.example.myshop.R;
import com.example.myshop.adapter.FragTabAdapter;
import com.example.myshop.app.Myapp;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.contract.MeContract;
import com.example.myshop.persenter.MePersenterImpl;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MeFragment extends BaseFrgment<MePersenterImpl> implements MeContract.MeView {


    private VerticalTabLayout vTab;
    private CustomViewPager vpSort;

    @Override
    protected void initData() {
        persenter.per();
    }


    @Override
    protected void initView(View inflate) {
        vTab = inflate.findViewById(R.id.vTab);
        vpSort = inflate.findViewById(R.id.vp_sort);
        //设置其是否能滑动换页
        vpSort.setScanScroll(true);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_me;
    }
    
    @Override
    public void getData(MeTabBean tabBean) {
        List<MeTabBean.DataBean.CategoryListBean> categoryList = tabBean.getData().getCategoryList();
        final ArrayList<CategoryTabFragment> fs = new ArrayList<>();
        for (int i = 0; i <categoryList.size(); i++) {
            int id = categoryList.get(i).getId();
            CategoryTabFragment f = new CategoryTabFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            Myapp.getMap().put("id",id);
            f.setArguments(bundle);
            fs.add(f);
        }

        FragTabAdapter fragTabAdapter = new FragTabAdapter(getChildFragmentManager(),fs,categoryList);
        vpSort.setAdapter(fragTabAdapter);
        vTab.setupWithViewPager(vpSort);
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: " + string);
    }
}
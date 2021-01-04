package com.example.myshop.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myshop.bean.MeTabBean;
import com.example.myshop.fragment.CategoryTabFragment;

import java.util.ArrayList;
import java.util.List;


public class FragTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fs;
    private List<MeTabBean.DataBean.CategoryListBean> mDataBeans;

    public FragTabAdapter(@NonNull FragmentManager fm, List<Fragment> fs, List<MeTabBean.DataBean.CategoryListBean> mDataBeans) {
        super(fm);
        this.fs = fs;
        this.mDataBeans = mDataBeans;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mDataBeans.get(position).getName();
    }
}

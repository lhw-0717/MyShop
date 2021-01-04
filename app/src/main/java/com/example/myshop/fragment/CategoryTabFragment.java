package com.example.myshop.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.adapter.TtabDataAdapter;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.bean.MeTabBean;
import com.example.myshop.contract.MeTabContract;
import com.example.myshop.persenter.MeTabPersenterImpl;

public class CategoryTabFragment extends BaseFrgment<MeTabPersenterImpl> implements MeTabContract.MeTabView {

    private ImageView sortDataImg;
    private TextView sortDesc;
    private TextView fenleiname;
    private RecyclerView rlvSort;
    private int id;
    private TtabDataAdapter adapter;

    @Override
    protected void initData() {
        persenter.per(id);
    }

    @Override
    protected void initView(View inflate) {
        sortDataImg = inflate.findViewById(R.id.sortData_img);
        sortDesc = inflate.findViewById(R.id.sort_desc);
        fenleiname = inflate.findViewById(R.id.fenleiname);
        rlvSort = inflate.findViewById(R.id.rlv_sort);
        id = getArguments().getInt("id");
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_category_tab;
    }

    @Override
    public void getData(MeTabBean tabBean) {
        Glide.with(getContext()).load(tabBean.getData().getCurrentCategory().getWap_banner_url()).into(sortDataImg);
        sortDesc.setText(tabBean.getData().getCurrentCategory().getFront_desc());
        fenleiname.setText("————"+tabBean.getData().getCurrentCategory().getName()+"分类————");
        rlvSort.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new TtabDataAdapter(getActivity(), tabBean.getData().getCurrentCategory().getSubCategoryList());
        rlvSort.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: "+string );
    }

}
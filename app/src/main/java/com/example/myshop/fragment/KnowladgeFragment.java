package com.example.myshop.fragment;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.adapter.KnowladgeAdapter;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.contract.KnowladgeContract;
import com.example.myshop.persenter.KnowladgePersenterImpl;

import static com.example.myshop.R.color.black;
import static com.example.myshop.R.color.white;

public class KnowladgeFragment extends BaseFrgment<KnowladgePersenterImpl> implements KnowladgeContract.KnowladgeView {

    private RecyclerView recyclerMain;
    private Button bntOne;
    private Button bntTwo;
    private KnowladgeAdapter adapter;

    @Override
    protected void initData() {
        persenter.per(1);
    }

    @Override
    protected void initView(View inflate) {
        recyclerMain = inflate.findViewById(R.id.recycler_main);
        bntOne = inflate.findViewById(R.id.bnt_one);
        bntTwo = inflate.findViewById(R.id.bnt_two);

        recyclerMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new KnowladgeAdapter();
        recyclerMain.setAdapter(adapter);
        bntOne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                bntTwo.setTextColor(black);
                bntOne.setTextColor(white);
                persenter.per(1);
            }
        });
        bntTwo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                bntOne.setTextColor(black);
                bntTwo.setTextColor(white);
                persenter.per(2);
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_knowladge;
    }

    @Override
    public void getData(SpecialBean specialBean) {
        adapter.getData(specialBean.getData().getData());
    }

    @Override
    public void getResult(String string) {
        Log.e("TAG", "getResult: "+string );
    }
}
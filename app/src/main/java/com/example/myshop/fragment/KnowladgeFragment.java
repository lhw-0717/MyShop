package com.example.myshop.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.TwoActivity;
import com.example.myshop.base.BaseFrgment;
import com.example.myshop.adapter.KnowladgeAdapter;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.contract.KnowladgeContract;
import com.example.myshop.persenter.KnowladgePersenterImpl;

public class KnowladgeFragment extends BaseFrgment<KnowladgePersenterImpl> implements KnowladgeContract.KnowladgeView {

    private RecyclerView recyclerMain;
    private Button bntOne;
    private Button bntTwo;
    private KnowladgeAdapter adapter;

    @Override
    protected void initData() {
        persenter.per();
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
            @Override
            public void onClick(View v) {
                bntOne.setTextColor(0x151515);
            }
        });
        bntTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TwoActivity.class);
                startActivity(intent);
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
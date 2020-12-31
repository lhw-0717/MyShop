package com.example.myshop;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.KnowladgeAdapter;
import com.example.myshop.bean.SpecialBean;
import com.example.myshop.contract.Knowladge2Contract;
import com.example.myshop.persenter.Knowladge2Persenterimpl;

public class TwoActivity extends BaseActivity<Knowladge2Persenterimpl> implements Knowladge2Contract.Knowladge2View {
    private RecyclerView recyclerMain;
    private Button bntOne;
    private Button bntTwo;
    private KnowladgeAdapter adapter;
    @Override
    protected void initData() {
        persenter.per();
    }

    @Override
    protected void initView() {
        recyclerMain = findViewById(R.id.recycler_main);
        bntOne = findViewById(R.id.bnt_one);
        bntTwo = findViewById(R.id.bnt_two);

        recyclerMain.setLayoutManager(new LinearLayoutManager(this));
        adapter = new KnowladgeAdapter();
        recyclerMain.setAdapter(adapter);
        bntOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bntOne.setTextColor(0x151515);
                finish();
            }
        });
        bntTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bntTwo.setTextColor(0xCFCFCC);
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_knowladge2;
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

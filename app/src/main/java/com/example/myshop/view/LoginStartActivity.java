package com.example.myshop.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.contract.LoginStartContract;
import com.example.myshop.persenter.LoginStartPersenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginStartActivity extends BaseActivity<LoginStartPersenter> implements LoginStartContract.ILoginStartView {

    private android.widget.TextView countdown;
    private Disposable subscribe;
    private int num = 0;

    @Override
    protected void initData() {
        persenter.refreshToken();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView() {
        countdown = findViewById(R.id.countdown);
        subscribe = Observable.interval(1, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                if (aLong<=3){
                    countdown.setText("倒计时"+(3-aLong)+"秒");
                }else {
                    subscribe.dispose();
                    Intent intent = new Intent(LoginStartActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login_start;
    }

    @Override
    public void countDown() {

    }
}
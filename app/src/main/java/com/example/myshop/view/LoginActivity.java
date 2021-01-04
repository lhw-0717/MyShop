package com.example.myshop.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.contract.LoginContract;
import com.example.myshop.persenter.LoginPersneterImpl;

public class LoginActivity extends BaseActivity<LoginPersneterImpl> implements LoginContract.ILoginView {

    private android.widget.EditText loginUserName;
    private android.widget.EditText loginPassWord;
    private android.widget.Button login;

    @Override
    protected void initData() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(getUserName())&&!TextUtils.isEmpty(getPassWoerd())) {
                    persenter.per(getUserName(),getPassWoerd());
                }
            }
        });

    }

    @Override
    protected void initView() {
        loginUserName = findViewById(R.id.login_user_name);
        loginPassWord = findViewById(R.id.login_pass_word);
        login = findViewById(R.id.login);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public String getUserName() {
        return loginUserName.getText().toString();
    }

    @Override
    public String getPassWoerd() {
        return loginPassWord.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
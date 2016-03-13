package com.yihukurama.lcontroler.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.yihukurama.lcontroler.LControlerApplication;
import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.model.access.DBManager;
import com.yihukurama.lcontroler.model.access.greendao.User;
import com.yihukurama.lcontroler.model.data.Constant;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;
import com.yihukurama.lcontroler.view.activity.base.InitActivityInterface;

import java.util.List;

public class LoginActivity extends BaseActivity implements InitActivityInterface {

    EditText accountET;
    EditText pwdET;
    Button loginBtn;
    Button registerBtn;
    String pwd;
    String account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initData();
    }

    @Override
    public void initView() {
        accountET = (EditText)findViewById(R.id.username);
        pwdET = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.login);
        registerBtn = (Button)findViewById(R.id.register);
    }

    @Override
    public void initData() {
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);

        //有缓存直接登录，无缓存需要验证用户名密码
        if(!LControlerApplication.getAppCache(Constant.ACCESSTOKEN).equals(Constant.CACHENULL)){


            List<User> userList = DBManager.getInstance(context).getDaoSession().loadAll(User.class);
            if (userList.size()!=0 && userList.get(0).getUserid()!=null){
                LControlerApplication.setUser(userList.get(0));
                LControlerApplication.setAppCache(Constant.ACCOUNTKEY, account);
                //跳转到MainActivity
                intent = new Intent(LoginActivity.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                //数据库没有缓存，需要重新登录
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                pwd = pwdET.getText().toString();
                account = accountET.getText().toString();
                login();
                break;
            case R.id.register:
                showToastShort("暂未开放");
                break;
        }
    }

    public void login(){
        if(pwd.equals("5502258") && account.equals("15914865707")){
            showToastShort("验证成功！");
            //数据库初始化并更新用户
            User user = LControlerApplication.getUser();
            user.setAccount(account);
            DBManager.getInstance(context).getDaoSession().getUserDao().insertOrReplace(user);
            LControlerApplication.setAppCache(Constant.ACCOUNTKEY, account);
            LControlerApplication.setAppCache(Constant.ACCESSTOKEN,account);
            intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            showToastLong("验证错误！");
        }
    }
}

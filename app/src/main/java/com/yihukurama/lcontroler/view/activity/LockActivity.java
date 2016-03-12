package com.yihukurama.lcontroler.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.model.access.DBManager;
import com.yihukurama.lcontroler.model.access.greendao.User;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;
import com.yihukurama.lcontroler.view.activity.base.InitActivityInterface;

import java.util.List;

public class LockActivity extends BaseActivity implements InitActivityInterface{

    EditText editText;
    Button unlockBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        initView();
        initData();
    }

    @Override
    public void initView() {
        unlockBtn = (Button)findViewById(R.id.btn_unlock);
        editText = (EditText)findViewById(R.id.editText);
    }

    @Override
    public void initData() {
        unlockBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_unlock:
                String pwd = editText.getText().toString();
                if(!pwd.equals("5502258")){
                    showToastLong("验证错误！");
                    break;
                }
                showToastShort("验证成功！");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘

                List<User> userList = DBManager.getInstance(context).getDaoSession().loadAll(User.class);

                //无个人信息，跳转个人信息编辑页
                if(userList.size() == 0 || userList.get(0).getNickname() == null){
                    //跳转到MainActivity
                    intent = new Intent(LockActivity.this,
                            UserInfoActivity.class);
                    startActivity(intent);
                }else{
                    //跳转到MainActivity
                    intent = new Intent(LockActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                }



                break;

        }
    }
}

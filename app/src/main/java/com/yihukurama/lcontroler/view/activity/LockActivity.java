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

                break;
        }
    }
}

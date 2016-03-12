package com.yihukurama.lcontroler.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;

//文章
public class LGameActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgame);

        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        findViewById(R.id.btn_main).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main:
                Intent intent = new Intent(LGameActivity.this,
                        WebActivity.class);
                startActivity(intent);

                break;

        }
    }
}

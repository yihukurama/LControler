package com.yihukurama.lcontroler.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yihukurama.lcontroler.BaseActivity;
import com.yihukurama.lcontroler.R;

//前奏 主歌 副歌 间奏 主歌 副歌 副歌 尾奏
public class MusicActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        findViewById(R.id.btn_main).setOnClickListener(this);
        findViewById(R.id.btn_pre).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main:
                Intent intent = new Intent(MusicActivity.this,
                        WebActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_pre:
                Intent intent1 = new Intent(MusicActivity.this,
                        WebActivity.class);
                startActivity(intent1);
                finish();
                break;

        }
    }
}

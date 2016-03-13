package com.yihukurama.lcontroler.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yihukurama.lcontroler.LControlerApplication;
import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.model.access.greendao.User;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button articleBtn;
    Button headIconBtn;
    TextView nickNameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }
    private void initView() {

        articleBtn = (Button)findViewById(R.id.btn_game);
        headIconBtn = (Button)findViewById(R.id.AIF_headIcon_btn);
        nickNameTV = (TextView)findViewById(R.id.AIF_name_tv);
    }
    private void initData() {

        articleBtn.setOnClickListener(this);
        headIconBtn.setOnClickListener(this);

    }
    private void refreshUI(){
        nickNameTV.setText(user.getNickname());
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshUI();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_game:
                Intent intent = new Intent(MainActivity.this,
                        LGameActivity.class);
                startActivity(intent);

                break;
            case R.id.AIF_headIcon_btn:
                Intent intent1 = new Intent(MainActivity.this,
                        UserInfoActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

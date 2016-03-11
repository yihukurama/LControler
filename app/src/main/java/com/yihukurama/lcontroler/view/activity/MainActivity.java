package com.yihukurama.lcontroler.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yihukurama.lcontroler.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    EditText editText;
    Button articleBtn;
    Button musicBtn;
    Button unlockBtn;
    TextView text;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        articleBtn.setOnClickListener(this);
        musicBtn.setOnClickListener(this);
        unlockBtn.setOnClickListener(this);
    }

    private void initView() {
        articleBtn = (Button)findViewById(R.id.btn_article);
        musicBtn = (Button)findViewById(R.id.btn_music);
        unlockBtn = (Button)findViewById(R.id.btn_unlock);
        editText = (EditText)findViewById(R.id.editText);
        text = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
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
                showToastLong("验证成功！");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
                unlockBtn.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);
                articleBtn.setVisibility(View.VISIBLE);
                musicBtn.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_article:
                Intent intent = new Intent(MainActivity.this,
                        ArticleActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_music:
                Intent intent1 = new Intent(MainActivity.this,
                        MusicActivity.class);
                startActivity(intent1);

                break;
        }
    }
}

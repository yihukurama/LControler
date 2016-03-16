package com.yihukurama.lcontroler.view.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yihukurama.lcontroler.LControlerApplication;
import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.model.access.greendao.User;

public class BaseActivity extends AppCompatActivity {
    protected  Intent intent;
    protected Context context;
    protected User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        init();

    }

    private void init() {
        user = LControlerApplication.getUser();
        context = this;
    }

    /**
     * show long toast
     * @param message
     */
    public void showToastLong(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * show short toast
     * @param message
     */
    public void showToastShort(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

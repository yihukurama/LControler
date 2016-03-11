package com.yihukurama.lcontroler.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.yihukurama.lcontroler.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
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

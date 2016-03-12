package com.yihukurama.lcontroler.view.activity.base;

import android.view.View;

/**
 * Created by dengshuai on 16/3/12.
 * 继承OnClickListener,每个activity都要实现监听控件点击方法
 * 初始化activity 必须的步骤
 */
public interface InitActivityInterface extends View.OnClickListener{
    //初始化界面控件
    void initView();
    //初始化其它数据
    void initData();
}

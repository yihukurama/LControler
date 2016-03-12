package com.yihukurama.lcontroler;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dengshuai on 16/3/12.
 */
public class LControlerApplication extends Application {
    private static LControlerApplication _instance;
    private static Context context;
    private static SharedPreferences appCache;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;



    }

    public static Application getInstance() {
        return _instance;
    }
    public static Context getContext(){
        return context;
    }



    public static SharedPreferences getAppCache() {
        return appCache;
    }



}

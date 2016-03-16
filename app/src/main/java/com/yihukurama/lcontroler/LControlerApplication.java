package com.yihukurama.lcontroler;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.yihukurama.lcontroler.control.sdk.imageloader.ImageLoaderApi;
import com.yihukurama.lcontroler.model.access.greendao.User;
import com.yihukurama.lcontroler.model.data.Constant;

/**
 * Created by dengshuai on 16/3/12.
 */
public class LControlerApplication extends Application {
    private static LControlerApplication _instance;
    private static Context context;
    private static SharedPreferences appCache;
    private static User user;
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LControlerApplication.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        //给User一些默认的值
        user = new User("15914865707");
        user.setNickname("昵称");
        context = getApplicationContext();
        appCache = getSharedPreferences("LControler", Context.MODE_PRIVATE);
        ImageLoaderApi.initImageLoader(context);


    }

    public static Application getInstance() {
        return _instance;
    }
    public static Context getContext(){
        return context;
    }



    public static String getAppCache(String k) {
        return appCache.getString(k, Constant.CACHENULL);
    }
    public static void setAppCache(String k,String value){
        SharedPreferences.Editor editor=appCache.edit();
        editor.putString(k, value);
        editor.commit();
    }


}

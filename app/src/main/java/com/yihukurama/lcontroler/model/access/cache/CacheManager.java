package com.yihukurama.lcontroler.model.access.cache;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by dengshuai on 16/3/15.
 */
public class CacheManager {
    private static CacheManager ourInstance;

    public static CacheManager getInstance() {
        if (ourInstance == null)
            ourInstance = new CacheManager();

        return ourInstance;
    }

    private CacheManager() {
    }

    public String saveInCache(Context context,byte[] bytes,String fileName){

        File file = new File(context.getCacheDir()+File.separator+fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(file.exists()){
            Log.i("LControler","保存头像成功"+file.getAbsolutePath());
        }else{
            Log.i("LControler","保存头像失败");
        }
        return file.getAbsolutePath();
    }


}

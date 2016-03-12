package com.yihukurama.lcontroler.view.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;

public class WebActivity extends BaseActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
        initData();
    }

    private void initView() {

        webView  = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小;
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //支持内容重新布局
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {

            }
        });
    }

    private void initData() {
        String url = "http://m.socialab.com.cn//m/";
        java.util.Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(92)+333;// 返回[0,10)集合中的整数，注意不包括10
        url+=result;
        //http://m.socialab.com.cn//m/415
        //333-415
        webView.loadUrl(url);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

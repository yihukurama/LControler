package com.yihukurama.lcontroler.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.control.sdk.imageloader.ImageLoaderApi;
import com.yihukurama.lcontroler.control.util.TransferUtil;
import com.yihukurama.lcontroler.model.access.DBManager;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;
import com.yihukurama.lcontroler.view.activity.base.InitActivityInterface;

public class UserInfoActivity extends BaseActivity implements InitActivityInterface {

    private static final int REQUESTCODE_PICK = 1;
    RelativeLayout headIconRL;
    ImageView headIcon;
    EditText nickNameET;
    Button saveBtn;
    String headUrl;
    String nickName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        initData();
    }

    @Override
    public void initView() {
        headIconRL = (RelativeLayout)findViewById(R.id.set_usericon);
        headIcon = (ImageView)findViewById(R.id.MPS_iv_userportrait);
        nickNameET = (EditText)findViewById(R.id.user_nickname);
        saveBtn = (Button)findViewById(R.id.save);
    }

    @Override
    public void initData() {
        saveBtn.setOnClickListener(this);
        headIcon.setOnClickListener(this);
        //1.从服务器请求数据更新数据库并重新初始化
        headUrl = user.getHeadurl();
        nickName = user.getNickname();
    }

    protected void refreshUI(){

        nickNameET.setText(nickName);
        ImageLoaderApi.getInstance().displayImage(headUrl, headIcon);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                user.setNickname(nickNameET.getText().toString());
                user.setHeadurl(headUrl);
                DBManager.getInstance(context).getDaoSession().insertOrReplace(user);
                showToastShort("保存成功");
                break;
            case R.id.MPS_iv_userportrait:
                //更换头像
                uploadHeadPhoto();
                break;


        }
    }

    private void uploadHeadPhoto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("更新头像");
        builder.setItems(new String[]{"拍照", "从本地选择"},
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        switch (which) {
                            case 0:
                                showToastShort("暂不支持！");
                                break;
                            case 1:
                                Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
                                pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                                startActivityForResult(pickIntent, REQUESTCODE_PICK);
                                break;
                            default:
                                break;
                        }
                    }
                });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUESTCODE_PICK:
                if (data == null || data.getData() == null) {
                    return;
                }

                Uri uri = data.getData();
                headUrl = "file://"+TransferUtil.getInstance().uri2url(context,uri);
                //imageLoader加载头像图片
                ImageLoaderApi.getInstance().displayImage(uri.toString(),headIcon);

                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshUI();
    }
}

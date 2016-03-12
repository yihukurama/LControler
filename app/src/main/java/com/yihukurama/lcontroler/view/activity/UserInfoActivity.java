package com.yihukurama.lcontroler.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yihukurama.lcontroler.R;
import com.yihukurama.lcontroler.control.util.TimeUtil;
import com.yihukurama.lcontroler.model.access.DBManager;
import com.yihukurama.lcontroler.model.access.greendao.User;
import com.yihukurama.lcontroler.view.activity.base.BaseActivity;
import com.yihukurama.lcontroler.view.activity.base.InitActivityInterface;

import java.util.ArrayList;

public class UserInfoActivity extends BaseActivity implements InitActivityInterface {

    private Button back;
    private Button certain;
    private EditText nicknameEdit;
    private EditText email;
    private RadioButton boy;
    private RadioButton girl;
    private EditText sign;
    private TextView iconname;
    private RelativeLayout province,choosecity;
    private RelativeLayout year,month,day;
    private RelativeLayout usericon;
    private TextView province_text,choosecity_text;
    private TextView yeartext,monthtext,daytext;
    private ImageView iconimage;
    private RelativeLayout uploading,uploaderr;
    private TextView uploadtv;

    private int width;
    private int whichone;
    private PopupWindow poupuWindow;
    private View popView;
    private ArrayList<String> city_list;
    private ArrayList<String> day_list;
    private String district;
    private long Birthday;
    private String protraitUrl;
    private String headurl;
    private Context mContext;
    //截取图片
    public static final int NONE = 0;
    public static final int PHOTOHRAPH = 1;// 拍照
    public static final int PHOTOZOOM = 2; // 缩放
    public static final int PHOTORESOULT = 3;// 结果

    private int parasHight=160;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        initData();
    }

    @Override
    public void initView() {

        certain = (Button) findViewById(R.id.MPS_btn_ok);
        nicknameEdit = (EditText) findViewById(R.id.MPS_editTxt_nicename);
        boy = (RadioButton) findViewById(R.id.MPS_radioboy);
        girl = (RadioButton) findViewById(R.id.MPS_radiogirl);
        iconname = (TextView) findViewById(R.id.MPS_tv_usericonname);
        year = (RelativeLayout) findViewById(R.id.MPS_rl_year);
        month = (RelativeLayout) findViewById(R.id.MPS_rl_month);
        day = (RelativeLayout) findViewById(R.id.MPS_rl_day);
        yeartext = (TextView) findViewById(R.id.MPS_tv_yeartext);
        monthtext = (TextView) findViewById(R.id.MPS_tv_monthtext);
        daytext = (TextView) findViewById(R.id.MPS_tv_daytext);
        usericon = (RelativeLayout) findViewById(R.id.MPS_rl_usericon);
        iconimage = (ImageView) findViewById(R.id.MPS_iv_userportrait);
        uploading = (RelativeLayout) findViewById(R.id.MPS_rl_loading);
        uploaderr = (RelativeLayout) findViewById(R.id.MPS_rl_err);
        uploadtv = (TextView) findViewById(R.id.MPS_tv_loading);

        certain.setOnClickListener(this);
        year.setOnClickListener(this);
        month.setOnClickListener(this);
        day.setOnClickListener(this);
        usericon.setOnClickListener(this);
        uploaderr.setOnClickListener(this);
    }

    @Override
    public void initData() {
       //1.从数据库取数据
       //2. 用数据库数据初始化
       //3.从服务器请求数据更新数据库并重新初始化

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MPS_btn_ok:
                //昵称
                String mynick = nicknameEdit.getText().toString().trim();
                if (mynick == null || mynick.length() == 0) {
                    showToastLong(getString(R.string.nickCanntNull));
                    break;
                }
                String yearString = yeartext.getText().toString();//年的内容
                String monthString = monthtext.getText().toString();
                String dayString = daytext.getText().toString();
                //生日
                String birthTemp = yearString + monthString + dayString;
                // 字符串=======>时间戳
                if (!yearString.equals("年") && !monthString.equals("月") && !dayString.equals("日")) {
                    Birthday = TimeUtil.stringToLong(birthTemp, "yyyy年MM月dd日");
                    System.out.println(birthTemp + "Birthday" + Birthday);
                    Birthday = Birthday / 1000;
                }


                //所有信息存入数据库并上传服务器
                User user = new User();
                user.setNickname(nicknameEdit.getText().toString());
                user.setUserid("0");
                DBManager.getInstance(context).getDaoSession().insertOrReplace(user);
                showToastShort("保存成功");
                break;
            case R.id.MPS_rl_usericon:

                break;
        }
    }


}

package com.example.administrator.login_test.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.login_test.R;
import com.example.administrator.login_test.UserAction;
import com.example.administrator.login_test.fragment.ChatFragment;
import com.example.administrator.login_test.fragment.DainaFragment;
import com.example.administrator.login_test.fragment.ErshouFragment;
import com.example.administrator.login_test.fragment.PindanFragment;
import com.example.administrator.login_test.fragment.SettingFragment;



//主界面，没有登录也能进入
public class SuccessActivity extends FragmentActivity {

    protected static final String TAG = "MainActivity";
    private Context mContext;
    private ImageButton ershou, daina, pindan, chat, setting;
    private View currentButton;


    private PopupWindow mPopupWindow;
    private LinearLayout buttomBarGroup;

    private UserAction userAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        mContext = this;

        findView();

        init();


    }

    @Override
    protected void onResume() {
        super.onResume();

        //默认二手界面
        ershou.performClick();
    }

    private void findView() {
        buttomBarGroup = (LinearLayout) findViewById(R.id.buttom_bar_group);
        ershou = (ImageButton) findViewById(R.id.ershou);
        daina = (ImageButton) findViewById(R.id.daina);
        pindan = (ImageButton) findViewById(R.id.pindan);
        chat = (ImageButton) findViewById(R.id.chat);
        setting = (ImageButton) findViewById(R.id.setting);


    }


    private void init() {
        ershou.setOnClickListener(ershouOnClickListener);
        daina.setOnClickListener(dainaOnClickListener);
        pindan.setOnClickListener(pindanOnClickListener);
        chat.setOnClickListener(chatOnClickListener);
        setting.setOnClickListener(settingOnClickListener);





    }


    //以下四个触发一个以后，分别进入各自的界面
    private View.OnClickListener ershouOnClickListener = new View.OnClickListener() {//消息页面
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ErshouFragment ershouFragment = new ErshouFragment();
            ft.replace(R.id.fl_content, ershouFragment);//切换页面
            ft.commit();
            setButton(v);
        }
    };

    private View.OnClickListener dainaOnClickListener = new View.OnClickListener() {//消息页面
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            DainaFragment dainaFragment = new DainaFragment();
            ft.replace(R.id.fl_content, dainaFragment);//切换页面
            ft.commit();
            setButton(v);
        }
    };

    private View.OnClickListener pindanOnClickListener = new View.OnClickListener() {//消息页面
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            PindanFragment pindanFragment = new PindanFragment();
            ft.replace(R.id.fl_content, pindanFragment);//切换页面
            ft.commit();
            setButton(v);
        }
    };

    private View.OnClickListener chatOnClickListener = new View.OnClickListener() {//消息页面
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ChatFragment chatFragment = new ChatFragment();
            ft.replace(R.id.fl_content, chatFragment);//切换页面
            ft.commit();
            setButton(v);
        }
    };

    private View.OnClickListener settingOnClickListener = new View.OnClickListener() {//消息页面
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            SettingFragment settingFragment = new SettingFragment();
            ft.replace(R.id.fl_content, settingFragment);//切换页面
            ft.commit();
            setButton(v);
        }
    };


    private void setButton(View v) {//切换显示底部按钮
        if (currentButton != null && currentButton.getId() != v.getId()) {
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton = v;
    }


}

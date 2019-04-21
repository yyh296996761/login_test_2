package com.example.administrator.login_test.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.login_test.R;


//只有一个按钮，就是进入主界面的，基本没用
public class MainActivity extends AppCompatActivity {

    private Button main2login;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext  = this;


        main2login = (Button) findViewById(R.id.main2login);

        main2login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, SuccessActivity.class);
                startActivity(intent);
            }
        });


    }



}

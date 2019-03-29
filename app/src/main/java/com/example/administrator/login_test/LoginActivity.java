package com.example.administrator.login_test;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {


    private EditText mAccount;
    private EditText mPassword;
    private Button mLoginButton;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        initViews();
    }

    protected void initViews() {
        mLoginButton = (Button) findViewById(R.id.login);
        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLoginButton.setOnClickListener(loginOnClickListener);
    }

    private View.OnClickListener loginOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String account = mAccount.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            if (account.equals("")) {
                Toast.makeText(LoginActivity.this, "请填写账号", Toast.LENGTH_SHORT).show();
                mAccount.requestFocus();
            } else if (password.equals("")) {
                Toast.makeText(LoginActivity.this, "请填写密码", Toast.LENGTH_SHORT).show();

            } else if (!VerifyUtils.matchAccount(account)) {
                Toast.makeText(LoginActivity.this, "账号格式错误", Toast.LENGTH_SHORT).show();

                mAccount.requestFocus();
            } else if (mPassword.length() < 6) {
                Toast.makeText(LoginActivity.this, "密码格式错误", Toast.LENGTH_SHORT).show();

            } else {
                tryLogin(account, password);
            }
        }
    };

    private void tryLogin(final String account, final String password) {
        new AsyncTask<Void, Void, Integer>() {

            @Override
            protected void onPreExecute() {//开始时，直到
                super.onPreExecute();
//                showLoadingDialog("正在登录,请稍后...");


//                ProgressDialog waitingDialog=
//                        new ProgressDialog(LoginActivity.this);
//                waitingDialog.setTitle("我是一个等待Dialog");
//                waitingDialog.setMessage("等待中...");
//                waitingDialog.setIndeterminate(true);
//                waitingDialog.setCancelable(false);
//                waitingDialog.show();
            }

            @Override
            protected Integer doInBackground(Void... params) {//反应滞后性，不灵敏

                User user = new User();
                user.setAccount(account);
                user.setPassword(password);
                userAction.loginVerify(user, mContext);//验证登录


                return ApplicationData.getInstance().getUserInfo().getId();

            }

            @Override
            protected void onPostExecute(Integer result) {
                super.onPostExecute(result);

                User u = ApplicationData.getInstance().getUserInfo();

//                Toast.makeText(mContext,u.getId()+":"+u.getFlag(),Toast.LENGTH_LONG).show();
                int getid = ApplicationData.getInstance().getUserInfo().getId();
                if (getid != -1 && getid != 0) {
//                    Toast.makeText(mContext,"id："+String.valueOf(getid),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mContext, SuccessActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(mContext, "无此人,id为:"+getid, Toast.LENGTH_LONG).show();
                }


            }
        }.executeOnExecutor(Executors.newCachedThreadPool());
//		}.execute();
    }
}

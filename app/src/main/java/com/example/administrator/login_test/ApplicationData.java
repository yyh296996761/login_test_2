package com.example.administrator.login_test;

/**
 * Created by Administrator on 2019/3/28.
 */

public class ApplicationData {


    private static ApplicationData mInitData;
    private static User mUser;


    public static ApplicationData getInstance() {
        if (mInitData == null) {
            mInitData = new ApplicationData();
        }
        if(mUser == null)
        {
            mUser = new User();
        }
        return mInitData;
    }

    private ApplicationData() {

    }


    public User getUserInfo() {
        return mUser;
    }

    public void setmUser(User user){
        this.mUser.setId(user.getId());
    }
}

package com.example.administrator.login_test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.login_test.R;

/**
 * Created by Administrator on 2019/4/4.
 */

public class DainaFragment extends Fragment{



    private View mBaseView;
    private Context mContext;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBaseView = inflater.inflate(R.layout.fragment_daina, null);
        return mBaseView;
    }


}

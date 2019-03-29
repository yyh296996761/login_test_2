package com.example.administrator.login_test;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/27.
 */

public class userAction {

//    static String string_front = "http://39.108.116.192:8080/MyServlet";


    public static void loginVerify(final User user, final Context mContext) {
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {

                final String url = "http://10.21.138.33:8080/YYH_Servlet/LoginServlet";
                //10.21.138.33
                //192.168.43.197
                //39.108.116.192
                String tag = "Login";//请求标记
                Model.getInstance().init(mContext);
                RequestQueue requestQueue = Model.getInstance().getVolleyRequest().getRequestQueue();
                requestQueue.cancelAll(tag);



                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try{


                                    JSONObject jsonObject = new JSONObject(response);
                                    User u = new User();
                                    u.setId(Integer.parseInt(jsonObject.get("Id").toString()));
//                                    Toast.makeText(mContext,String.valueOf(u.getId()),Toast.LENGTH_LONG).show();
//                                    Toast.makeText(mContext,jsonObject.get("Id").toString(),Toast.LENGTH_LONG).show();
                                    ApplicationData.getInstance().setmUser(u);


                                }catch (JSONException e) {
                                    //做自己的请求异常操作，如Toast提示（“无网络连接”等）
                                    Toast.makeText(mContext,"1:"+e.toString(),Toast.LENGTH_LONG).show();

                                }
                                catch(Exception e){
                                    Toast.makeText(mContext,"2:"+e.toString(),Toast.LENGTH_LONG).show();
                                }



                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("AccountNumber", user.getAccount());
                        params.put("password", user.getPassword());
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });

    }
}

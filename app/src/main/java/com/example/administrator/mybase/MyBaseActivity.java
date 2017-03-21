package com.example.administrator.mybase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Steven on 2017/2/16.
 */

public class MyBaseActivity extends AppCompatActivity {

    /** 用来保存所在存在的 Activity */
    private static ArrayList<MyBaseActivity> onlineActivityList = new ArrayList<MyBaseActivity>();

    /**
     * 依次退出当前存在的所有 Activity
     */
    public static void finishAll() {
        Iterator<MyBaseActivity> iterator = onlineActivityList.iterator();
        while (iterator.hasNext()) {
            iterator.next().finish();
        }
    }

    /**
     * @param mClass
     *            要跳转的activity
     */
    protected void startActivity(Class<?> mClass) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
    }

    /**
     * @param mClass
     *            要跳转的activity
     * @param isFirst
     *            是否要结束当前的activity
     */
    protected void startActivity(Class<?> mClass, boolean isFirst) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
        if (isFirst) {
            this.finish();
        }
    }

    /**
     *
     * @param mClass
     *            要跳转的activity
     * @param bundle
     *            跳转的时候传值
     */
    protected void startActivity(Class<?> mClass, Bundle bundle) {
        Intent intent = new Intent(this, mClass);
        if (bundle != null) {// 如果bundle不为空就传值
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    // 带动画的跳转
    /**
     *
     * @param mClass
     *            要跳转的activity
     * @param inAnimID
     *            进入的动画
     * @param outAnimID
     *            出去的动画
     */
    protected void startActivity(Class<?> mClass, int inAnimID, int outAnimID) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }

    // 带动画跳转，并传递参数
    /**
     *
     * @param mClass
     *            要跳转的activity
     * @param inAnimID
     *            进入的动画
     * @param outAnimID
     *            出去的动画
     * @param bundle
     *            跳转的时候传值
     */
    protected void startActivity(Class<?> mClass, int inAnimID, int outAnimID,
                                 Bundle bundle) {
        Intent intent = new Intent(this, mClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }

    /**
     *
     * @param str 需要吐司的字符串
     */
    protected void showToast(String str){
        Toast.makeText(this, str+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(getClass().getName(),"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(getClass().getName(),"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(getClass().getName(),"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(getClass().getName(),"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(getClass().getName(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(),"onDestroy");
        // 清空 Activity
        if (onlineActivityList.contains(this)) {
            onlineActivityList.remove(this);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(getClass().getName(),"onRestart");
    }


}

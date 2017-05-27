package com.opensource.vrphoto.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/1.
 */
public class Utils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getDisplayWidth(Activity context){
        WindowManager wm = context.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    public static int getDisplayWHHeigth(Activity context){
        WindowManager wm = context.getWindowManager();

        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 数字时间串
     * @return
     */
    public static String getDateNumber(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 随机num个字母
     * @return
     */
    public static String randomCapital(int num){
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer buffer = new StringBuffer();
        for (int i =0; i< num; i++){
            buffer.append(chars.charAt((int)(Math.random() * 26)));
        }
        return  buffer.toString();
    }


    /**
     * 获取一个四元素
     * @param Q
     * @param rv
     */
    public static void getQuaternionFromVector(float[] Q, float[] rv) {
        if (rv.length >= 4) {
            Q[0] = rv[3];
        } else {
            Q[0] = 1 - rv[0]*rv[0] - rv[1]*rv[1] - rv[2]*rv[2];
            Q[0] = (Q[0] > 0) ? (float) Math.sqrt(Q[0]) : 0;
        }
        Q[1] = -rv[0];
        Q[2] = -rv[1];
        Q[3] = -rv[2];
    }

}

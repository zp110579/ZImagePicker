package com.lzy.imagepicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.lzy.imagepicker.bean.ZImagePickerListener;

public class ImagePickerManager {
    private Activity mActivity;
    private ZImagePickerListener mZImagePickerListener;
    private int type = 0; //0：矩形 1：圆形

    /**
     * 矩形截图
     *
     * @return
     */
    public static ImagePickerManager newRectangleImagePickerManager() {
        ImagePickerManager fragment = new ImagePickerManager();
        return fragment;
    }

    /**
     * 圆形截图
     *
     * @return
     */
    public static ImagePickerManager newCircleImagePickerManager() {
        ImagePickerManager fragment = new ImagePickerManager();
        fragment.setType(1);
        return fragment;
    }

    private void setType(int type) {
        this.type = type;
    }

    public ImagePickerManager with(Activity activity) {
        mActivity = activity;
        return this;
    }

    public ImagePickerManager with(Fragment fragment) {
        mActivity = fragment.getActivity();
        return this;
    }

    public ImagePickerManager with(DialogFragment dialogFragment) {
        mActivity = dialogFragment.getActivity();
        return this;
    }

    public ImagePickerManager setZImagePickerListener(ZImagePickerListener ZImagePickerListener) {
        mZImagePickerListener = ZImagePickerListener;
        return this;
    }

    public void letGo() {

    }
}

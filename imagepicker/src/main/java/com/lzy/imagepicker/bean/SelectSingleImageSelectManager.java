package com.lzy.imagepicker.bean;

import android.app.Activity;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ZxingResultFragment;
import com.lzy.imagepicker.view.CropImageView;

/**
 * 单个图片的选择
 */
public class SelectSingleImageSelectManager {
    private Activity mActivity;

    ImagePicker imagePicker = ImagePicker.getInstance();

    public SelectSingleImageSelectManager(Activity activity) {
        mActivity = activity;
        imagePicker.setShowCamera(false);
        imagePicker.setMultiMode(false);
        imagePicker.setCrop(false);//设置选择后可以编辑
    }

    /**
     * 是否在第一个位置显示照相机的图片
     */
    public SelectSingleImageSelectManager setShowCamera() {
        imagePicker.setShowCamera(true);
        return this;
    }


    public SelectSingleImageSelectManager setMultiMode() {
        imagePicker.setMultiMode(true);
        return this;
    }

    /**
     * 设置矩形编辑
     *
     * @return
     */
    public SelectSingleImageSelectManager setRectangleEditSize(int width, int height) {
        imagePicker.setFocusSize(width, height);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setCrop(true);//设置选择后可以编辑
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        return this;
    }

    /**
     * 设置圆形编辑
     *
     * @return
     */
    public SelectSingleImageSelectManager setCircleEditSize(int width) {
        imagePicker.setFocusSize(width, width);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setCrop(true);//设置选择后可以编辑
        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        return this;
    }


    public void letsGo(OnImagePickerListener onImagePickerListener) {
        ZxingResultFragment zxingResultFragment = ZxingResultFragment.newInstant(false);
        zxingResultFragment.prepareRequest(mActivity, onImagePickerListener);
    }
}

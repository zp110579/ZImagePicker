package com.lzy.imagepicker.bean;

import android.app.Activity;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ImagePickerFragment;
import com.lzy.imagepicker.view.CropImageView;

/**
 * 多个图片的选择
 */
public class ManyImageSelectManager {
    private Activity mActivity;
    ImagePicker imagePicker = ImagePicker.getInstance();

    public ManyImageSelectManager(Activity activity, int selectNumber) {
        imagePicker.setSelectLimit(selectNumber);    //选中数量限制
        imagePicker.setMultiMode(true);
        imagePicker.setCrop(false);//设置选择后可以编辑
        imagePicker.setSaveRectangle(false); //是否按矩形区域保存
        mActivity = activity;
    }

    public void letsGo(OnImagePickerListener onImagePickerListener) {
        ImagePickerFragment imagePickerFragment = ImagePickerFragment.newInstant(false);
        imagePickerFragment.prepareRequest(mActivity, onImagePickerListener);
    }
}

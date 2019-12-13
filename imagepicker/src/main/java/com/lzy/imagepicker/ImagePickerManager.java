package com.lzy.imagepicker;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.lzy.imagepicker.bean.CameraPickerImageSelectManager;
import com.lzy.imagepicker.bean.PhotoPickerImageSelectManager;
import com.lzy.imagepicker.bean.OnImagePickerListener;

public class ImagePickerManager {
    private Activity mActivity;


    public ImagePickerManager(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 图库里选择图片
     *
     * @return
     */
    public PhotoPickerImageSelectManager newPhotoPickerImageSelectManager() {
        return new PhotoPickerImageSelectManager(mActivity);
    }

    /**
     * 像机直接拍摄
     *
     * @return
     */
    public CameraPickerImageSelectManager newCameraPickerImageSelectManager() {
        return new CameraPickerImageSelectManager(mActivity);
    }

    public static ImagePickerManager with(Activity activity) {
        return new ImagePickerManager(activity);
    }

    public static ImagePickerManager with(Fragment fragment) {
        return new ImagePickerManager(fragment.getActivity());
    }

    public static ImagePickerManager with(DialogFragment dialogFragment) {
        return new ImagePickerManager(dialogFragment.getActivity());
    }
}

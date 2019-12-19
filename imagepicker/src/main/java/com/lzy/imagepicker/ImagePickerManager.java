package com.lzy.imagepicker;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.lzy.imagepicker.bean.CameraPickerImageSelectManager;
import com.lzy.imagepicker.bean.ManyImageSelectManager;
import com.lzy.imagepicker.bean.SingleImageSelectManager;

public class ImagePickerManager {
    private Activity mActivity;


    public ImagePickerManager(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 图库里单个图片选择
     *
     * @return
     */
    public SingleImageSelectManager singleSelectImage() {
        return new SingleImageSelectManager(mActivity);
    }

    /**
     * 图库里多个图片选择
     *
     * @return
     */
    public ManyImageSelectManager manySelectImages(int selectLimit) {
        return new ManyImageSelectManager(mActivity, selectLimit);
    }

    /**
     * 像机直接拍摄
     *
     * @return
     */
    public CameraPickerImageSelectManager cameraImage() {
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

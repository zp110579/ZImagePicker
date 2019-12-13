package com.lzy.imagepicker.bean;

import android.app.Activity;

/**
 * 相册选择图片
 */
public class PhotoPickerImageSelectManager {
    private Activity mActivity;

    public PhotoPickerImageSelectManager(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 单个图片的选择
     *
     * @return
     */
    public SelectSingleImageSelectManager singleMode() {
        return new SelectSingleImageSelectManager(mActivity);
    }

    /**
     * 多个图片的选择
     *
     * @return
     */
    public SelectManyImageSelectManager manyMode(int selectLimit) {
        return new SelectManyImageSelectManager(mActivity, selectLimit);
    }

}

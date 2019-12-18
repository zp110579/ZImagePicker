package com.lzy.imagepicker.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.bean.OnImagePickerListener;

import java.util.ArrayList;

public class ImagePickerFragment extends Fragment {
    private OnImagePickerListener mOnImagePickerListener;
    boolean isCameraMode = false;
    private int REQUEST_CODE_SCAN = 200;

    public static ImagePickerFragment newInstant(boolean isCameraMode) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isCameraMode", isCameraMode);//是否是相机模式
        ImagePickerFragment fragment = new ImagePickerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void prepareRequest(Activity activity, OnImagePickerListener listener) {
        //将当前的请求码和对象添加到集合中
        this.mOnImagePickerListener = listener;
        activity.getFragmentManager().beginTransaction().add(this, activity.getClass().getName()).commitAllowingStateLoss();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        isCameraMode = bundle.getBoolean("isCameraMode");
        openActivity();
    }

    private void openActivity() {
        Intent intent = new Intent(getActivity(), ImageGridActivity.class);
        if (isCameraMode) {
            intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
        }
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN) {
            if (mOnImagePickerListener != null) {
                if (data != null) {
                    ArrayList<ImageItem> imageItemArrayList = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                    mOnImagePickerListener.onImagePickerResult(imageItemArrayList);
                } else {
                    mOnImagePickerListener.onImagePickerResult(new ArrayList<ImageItem>());
                }
            }
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}

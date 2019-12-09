package com.lzy.imagepicker.bean;

import java.util.ArrayList;

public interface ZImagePickerListener {

    void onResult(ArrayList<ImageItem> imageItemArrayList);

    void onCancel();

}

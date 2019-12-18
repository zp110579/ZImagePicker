package com.zee.zxing.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ImagePickerManager;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.bean.OnImagePickerListener;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.zee.log.ZLog;
import com.zee.utils.ZLibrary;
import com.zee.utils.ZScreenUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ZLibrary.init(getApplication(), true);
        initView();
    }


    private void initView() {
        /*扫描按钮*/
        findViewById(R.id.scanBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePickerManager.with(MainActivity.this).newPhotoPickerImageSelectManager().singleMode().setRectangleEditSize(ZScreenUtils.getScreenWidth(), ZScreenUtils.getScreenWidth()).letsGo(new OnImagePickerListener() {
                    @Override
                    public void onImagePickerResult(ArrayList<ImageItem> imageItemArrayList) {
                        ZLog.i(imageItemArrayList);
                    }
                });
            }
        });

        findViewById(R.id.encodeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePickerManager.with(MainActivity.this).newCameraPickerImageSelectManager().setRectangleEdit().letsGo(new OnImagePickerListener() {
                    @Override
                    public void onImagePickerResult(ArrayList<ImageItem> imageItemArrayList) {
                        ZLog.i(imageItemArrayList);
                    }
                });
            }
        });
        initSelectPic();
    }

    private void initSelectPic() {
        //设置头像相关
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PhotoPickerImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮(相机选择的时候才会有用)
        imagePicker.setMultiMode(false); //为真的时候每个图片上显示选择的框，选中的也会有遮盖
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusSize(800, 800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutSize(1000, 1000);//保存文件的高度。单位像素
    }

}

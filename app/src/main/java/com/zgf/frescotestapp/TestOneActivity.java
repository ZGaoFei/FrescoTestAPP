package com.zgf.frescotestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zgf.frescotestapp.utils.FrescoUtils;

public class TestOneActivity extends AppCompatActivity {
    private static final String url1 = "http://pic31.nipic.com/20130802/7487939_100434185000_2.jpg";
    private static final String url2 = "http://img5.imgtn.bdimg.com/it/u=1647638103,2698639524&fm=23&gp=0.jpg";
    private static final String url3 = "http://s1.dwstatic.com/group1/M00/46/FC/d578e89c49f1dcd864137bb09b57054d.gif";

    private SimpleDraweeView image1;
    private SimpleDraweeView image2;
    private SimpleDraweeView image3;
    private SimpleDraweeView image4;
    private SimpleDraweeView image5;
    private SimpleDraweeView image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);

        initView();
        setImage();
    }

    private void initView() {
        image1 = (SimpleDraweeView) findViewById(R.id.iv_test_one);
        image2 = (SimpleDraweeView) findViewById(R.id.iv_test_two);
        image3 = (SimpleDraweeView) findViewById(R.id.iv_test_three);
        image4 = (SimpleDraweeView) findViewById(R.id.iv_test_four);
        image5 = (SimpleDraweeView) findViewById(R.id.iv_test_five);
        image6 = (SimpleDraweeView) findViewById(R.id.iv_test_six);
    }

    private void setImage() {
        FrescoUtils.loadImage(url1, image1);// 网络

        FrescoUtils.loadImage(R.drawable.local_image, image2);// 本地

        FrescoUtils.loadImage(this, url1, image3, 5, 5, 5, 5);

        FrescoUtils.loadImage(url2, image4);

        FrescoUtils.loadImage(url2, image5, 2, 10);

        FrescoUtils.loadImageGif(url3, image6);
//        FrescoUtils.loadImageGifAuto(url3, image6);
    }
}

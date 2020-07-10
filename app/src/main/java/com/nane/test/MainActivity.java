package com.nane.test;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.image)
    public ImageView image;

    ObjectAnimator objectAnimator;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        objectAnimator = ObjectAnimator.ofFloat(image,"translationY",0f,300f,0f);
        objectAnimator.setDuration(2*1000L);
        objectAnimator.setRepeatCount(Animation.INFINITE);
        objectAnimator.setRepeatMode(Animation.RESTART);
    }


    @OnClick({R.id.btn_start,R.id.btn_stop})
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_start:
                objectAnimator.start();
                break;

            case R.id.btn_stop:
                objectAnimator.cancel();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

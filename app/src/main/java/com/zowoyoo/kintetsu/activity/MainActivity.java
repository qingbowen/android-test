package com.zowoyoo.kintetsu.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.zowoyoo.kintetsu.R;
import com.zowoyoo.kintetsu.exception.AppException;
import com.zowoyoo.kintetsu.tools.QRcodeUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private final int REQUEST_TAKE_PHOTO_PERMISSION = 1;
    private final int REQUEST_CODE_SCAN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注意：高版本需要获取运行时权限,因业务简单，暂不封装
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_TAKE_PHOTO_PERMISSION);

        } else {

        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //点击扫码打开相机
            case R.id.scan_code:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
                break;
            //点击打印小票
            case R.id.print_detail:

                break;

        }
    }


    //扫码返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                try {
                    //解析扫描的数据
                    String code = QRcodeUtil.getCode(content);
                    //发送请求

                    //处理请求
                } catch (AppException e) {
                    this.showToastShort(e.getMessage());
                }
            }
        }
    }


}

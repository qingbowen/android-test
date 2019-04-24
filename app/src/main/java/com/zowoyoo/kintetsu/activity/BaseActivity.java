package com.zowoyoo.kintetsu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {


    public void showToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

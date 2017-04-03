package com.zhc.appdesignlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhc.appdesignlibrary.strategy.BigDataEncryptStrategy;
import com.zhc.appdesignlibrary.strategy.LogDataEntity;
import com.zhc.appdesignlibrary.strategy.LogEncrypt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void encodeLogData(LogDataEntity dataEntity) {


    }
}

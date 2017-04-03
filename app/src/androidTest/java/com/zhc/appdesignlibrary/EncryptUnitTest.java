package com.zhc.appdesignlibrary;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.zhc.appdesignlibrary.strategy.BigDataEncryptStrategy;
import com.zhc.appdesignlibrary.strategy.BusinessEncryptStrategy;
import com.zhc.appdesignlibrary.strategy.LogDataEntity;
import com.zhc.appdesignlibrary.strategy.LogEncrypt;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Created by qqq on 2017/4/3.
 */
@RunWith(AndroidJUnit4.class)
public class EncryptUnitTest {

    private static final String TAG = "EncryptUnitTest";

    @Test
    public void encryptBigDataStrategyTest() {
        LogDataEntity entity = new LogDataEntity();
        entity.ad_action = "pv";
        LogEncrypt<byte[]> encrypt = new LogEncrypt<>();
        encrypt.setStrategy(new BigDataEncryptStrategy());
        byte[] arr = encrypt.encryptLogEntity(entity);
        Log.i(TAG, "打印出byte数组 ：\n" + Arrays.toString(arr));
    }

    @Test
    public void encryptBusinessStrategyTest() {
        LogDataEntity entity = new LogDataEntity();
        entity.ad_action = "pv";
        LogEncrypt<String> encrypt = new LogEncrypt<>();
        encrypt.setStrategy(new BusinessEncryptStrategy());
        String json = encrypt.encryptLogEntity(entity);
        Log.i(TAG, "打印出String ：\n" + json);
    }
}

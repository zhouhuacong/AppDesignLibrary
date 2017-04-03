package com.zhc.appdesignlibrary.strategy;

/**
 * Created by qqq on 2017/4/3.
 */

public interface IEncryptStrategy<T> {

    T encryptLog(LogDataEntity entity);

}

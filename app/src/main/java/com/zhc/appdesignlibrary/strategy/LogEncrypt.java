package com.zhc.appdesignlibrary.strategy;

/**
 * 上报数据加密类
 */
public class LogEncrypt<T> {

    private IEncryptStrategy<T> mStrategy;

    public void setStrategy(IEncryptStrategy<T> strategy) {
        mStrategy = strategy;
    }

    public T encryptLogEntity(LogDataEntity entity) {
        return mStrategy.encryptLog(entity);
    }

}

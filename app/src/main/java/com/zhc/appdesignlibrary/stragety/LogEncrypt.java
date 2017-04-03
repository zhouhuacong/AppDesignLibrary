package com.zhc.appdesignlibrary.stragety;

/**
 * 上报数据加密类
 */
public class LogEncrypt<T> {

    IEncryptStrategy mStrategy;

    public void setStrategy(IEncryptStrategy strategy) {
        mStrategy = strategy;
    }

    public T encryptLogEntity(LogDataEntity entity) {
        return (T) mStrategy.encryptLog(entity);
    }

}

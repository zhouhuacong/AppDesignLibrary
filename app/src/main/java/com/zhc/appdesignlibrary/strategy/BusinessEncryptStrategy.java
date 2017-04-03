package com.zhc.appdesignlibrary.strategy;

/**
 * 服务端加密方式，使用json
 */
public class BusinessEncryptStrategy implements IEncryptStrategy<String> {

    @Override
    public String encryptLog(LogDataEntity entity) {
        return entity.toString();
    }

}

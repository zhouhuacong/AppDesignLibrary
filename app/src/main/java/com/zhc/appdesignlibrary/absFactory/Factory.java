package com.zhc.appdesignlibrary.absFactory;

/**
 * Created by qqq on 2017/2/23.
 */

public abstract class Factory {

    /**
     * 创造产品，具体什么产品由子类去实现
     *
     * @return 产品的抽象类
     */
    public abstract <T extends Product> T createProduct(Class<T> clz);

}

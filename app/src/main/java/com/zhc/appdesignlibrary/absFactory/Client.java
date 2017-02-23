package com.zhc.appdesignlibrary.absFactory;

/**
 * Created by qqq on 2017/2/23.
 */

public class Client {

    public void useProduct() {
        new ConcreateFactory().createProduct(ConcreateProductA.class).method();
    }
}

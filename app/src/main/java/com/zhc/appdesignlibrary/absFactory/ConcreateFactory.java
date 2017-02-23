package com.zhc.appdesignlibrary.absFactory;

/**
 * Created by qqq on 2017/2/23.
 */

public class ConcreateFactory extends Factory {


    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product p = null;
        try {
            p = (Product) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) p;
    }
}

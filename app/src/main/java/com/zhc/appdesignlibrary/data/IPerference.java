package com.zhc.appdesignlibrary.data;

/**
 * Created by qqq on 2017/3/19.
 */

public interface IPerference<K, V> {

    void save(PerferenceValues values);

    V get(K k);

    void remove(K key);

    void clear();
}

package com.zhc.appdesignlibrary.data;

/**
 * Created by qqq on 2017/3/19.
 */

public interface RWLockTransactionListener {
    void onWriteTransaction();

    String onReadTransaction();
}

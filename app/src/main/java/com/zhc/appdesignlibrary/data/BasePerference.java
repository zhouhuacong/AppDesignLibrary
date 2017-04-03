package com.zhc.appdesignlibrary.data;

import android.text.TextUtils;

import com.zhc.appdesignlibrary.utils.SharedPreferenceUtils;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by qqq on 2017/3/19.
 */

public abstract class BasePerference implements IPerference<String, String> {

    private final ReadWriteLock mRWLock = new ReentrantReadWriteLock();

    protected abstract String getTableName();

    @Override
    public void save(final PerferenceValues values) {
        if (values == null) {
            return;
        }
        lockWriteInterruptibly(new RWLockTransactionListener() {
            @Override
            public void onWriteTransaction() {
                Set<String> keys = values.keySet();
                for (String key : keys) {
                    String value = values.getAsString(key);
                    if (TextUtils.isEmpty(value)) {
                        continue;
                    }

                }
            }

            @Override
            public String onReadTransaction() {
                return null;
            }
        });
    }

    @Override
    public String get(final String key) {
        return lockReadInterruptibly(new RWLockTransactionListener() {
            @Override
            public void onWriteTransaction() {

            }

            @Override
            public String onReadTransaction() {
                return getValue(key);
            }
        });
    }

    protected  String getValue(String key) {
        return SharedPreferenceUtils.getSharedPreferencesValue(
                getTableName(), key, "");
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void clear() {

    }

    protected void saveValues(String key, String value) {
        SharedPreferenceUtils.setSharedPreferences(getTableName(), key, value);
    }

    private void lockWriteInterruptibly(RWLockTransactionListener listener) {
        try {
            mRWLock.writeLock().lockInterruptibly();
            listener.onWriteTransaction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mRWLock.writeLock().unlock();
        }
    }

    private String lockReadInterruptibly(RWLockTransactionListener listener) {
        try {
            mRWLock.readLock().lockInterruptibly();
            return listener.onReadTransaction();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            mRWLock.readLock().unlock();
        }
    }
}

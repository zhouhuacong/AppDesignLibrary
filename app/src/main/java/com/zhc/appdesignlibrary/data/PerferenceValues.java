package com.zhc.appdesignlibrary.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.zhc.appdesignlibrary.utils.ObjectUtils;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by qqq on 2017/3/19.
 */

public class PerferenceValues implements Parcelable{

    public static final String TAG = "";

    private final HashMap<String, Object> mValues;

    public PerferenceValues() {
        mValues = new HashMap<>(8);
    }

    public PerferenceValues(int size) {
        mValues = new HashMap<>(size, 1.0f);
    }

    public PerferenceValues(Parcel in) {
        mValues = in.readHashMap(null);
    }

    public void put(String key, String value) {
        mValues.put(key, value);
    }

    public void putAll(PerferenceValues other) {
        mValues.putAll(other.mValues);
    }

    public void put(String key, Byte value) {
        mValues.put(key, value);
    }

    public void put(String key, Short value) {
        mValues.put(key, value);
    }

    public void put(String key, Integer value) {
        mValues.put(key, value);
    }

    public void put(String key, Long value) {
        mValues.put(key, value);
    }

    public void put(String key, Float value) {
        mValues.put(key, value);
    }

    public void put(String key, Double value) {
        mValues.put(key, value);
    }

    public void put(String key, Boolean value) {
        mValues.put(key, value);
    }

    public void put(String key, byte[] value) {
        mValues.put(key, value);
    }

    public void putNull(String key) {
        mValues.put(key, null);
    }

    public int size() {
        return mValues.size();
    }

    public void remove(String key) {
        mValues.remove(key);
    }

    public void clear() {
        mValues.clear();
    }

    public boolean containsKey(String key) {
        return mValues.containsKey(key);
    }

    public Object get(String key) {
        return mValues.get(key);
    }

    public String getAsString(String key) {
        return ObjectUtils.getAsString(mValues.get(key));
    }

    public Long getAsLong(String key) {
        return ObjectUtils.getAsLong(mValues.get(key));
    }

    public Integer getAsInteger(String key) {
        return ObjectUtils.getAsInteger(mValues.get(key));
    }

    public Short getAsShort(String key) {
        return ObjectUtils.getAsShort(mValues.get(key));
    }

    public Byte getAsByte(String key) {
        return ObjectUtils.getAsByte(mValues.get(key));
    }

    public Double getAsDouble(String key) {
        return ObjectUtils.getAsDouble(mValues.get(key));
    }

    public Float getAsFloat(String key) {
        return ObjectUtils.getAsFloat(mValues.get(key));
    }

    public Boolean getAsBoolean(String key) {
        return ObjectUtils.getAsBoolean(mValues.get(key));
    }

    public byte[] getAsByteArray(String key) {
        return ObjectUtils.getAsByteArray(mValues.get(key));
    }

    public Set<String> keySet() {
        return mValues.keySet();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(mValues);
    }

    public static final Creator<PerferenceValues> CREATOR = new Creator<PerferenceValues>() {
        @Override
        public PerferenceValues createFromParcel(Parcel in) {
            return new PerferenceValues(in);
        }

        @Override
        public PerferenceValues[] newArray(int size) {
            return new PerferenceValues[size];
        }
    };
}

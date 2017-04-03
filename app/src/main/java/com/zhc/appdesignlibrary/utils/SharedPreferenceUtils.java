package com.zhc.appdesignlibrary.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zhc.appdesignlibrary.MtbGlobalAdConfig;


/**
 * @author sunyuxin 16/7/28.
 */
public final class SharedPreferenceUtils {

    private SharedPreferenceUtils() {
    }

    public static void clearSharedPreferences(String tableName) {
        if (!TextUtils.isEmpty(tableName) && MtbGlobalAdConfig.getApplication() != null
                && MtbGlobalAdConfig.getApplication().getApplicationContext() != null) {
            MtbGlobalAdConfig.getApplication().getApplicationContext()
                    .getSharedPreferences(tableName, 0)
                    .edit()
                    .clear()
                    .apply();
        }
    }

    private static SharedPreferences getSharedPreferences(String tableName) {
        if (!TextUtils.isEmpty(tableName) && MtbGlobalAdConfig.getApplication() != null
                && MtbGlobalAdConfig.getApplication().getApplicationContext() != null) {
            return MtbGlobalAdConfig.getApplication().getApplicationContext()
                    .getSharedPreferences(tableName, 0);
        } else {
            return null;
        }
    }

    public static boolean getSharedPreferencesBoolean(String tableName, String key, boolean pDefValue) {
        if (assertParams(tableName, key)) {
            return false;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        return sharedPreferences != null && sharedPreferences.getBoolean(key, pDefValue);
    }

    public static int getSharedPreferencesInt(String tableName, String key) {
        if (assertParams(tableName, key)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, -1);
        } else {
            return -1;
        }
    }

    public static boolean getSharedPreferencesValue(String tableName, String key, boolean defValue) {
        if (assertParams(tableName, key)) {
            return false;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        return sharedPreferences != null && sharedPreferences.getBoolean(key, defValue);
    }

    public static float getSharedPreferencesValue(String tableName, String key, float defValue) {
        if (assertParams(tableName, key)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat(key, defValue);
        } else {
            return -1;
        }
    }

    public static int getSharedPreferencesValue(String tableName, String key, int defValue) {
        if (assertParams(tableName, key)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, defValue);
        } else {
            return -1;
        }
    }

    public static long getSharedPreferencesValue(String tableName, String key, long defValue) {
        if (assertParams(tableName, key)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(key, defValue);
        } else {
            return -1;
        }
    }

    public static String getSharedPreferencesValue(String tableName, String key, String defValue) {
        if (assertParams(tableName, key)) {
            return "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, defValue);
        } else {
            return "";
        }
    }

    public static void setSharedPreferences(String tableName, String key, boolean value) {
        if (assertParams(tableName, key)) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(key, value).apply();
        }
    }

    public static void setSharedPreferences(String tableName, String key, float value) {
        if (assertParams(tableName, key)) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(key, value).apply();
        }
    }

    public static void setSharedPreferences(String tableName, String key, int value) {
        if (assertParams(tableName, key)) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(key, value).apply();
        }
    }

    public static void setSharedPreferences(String tableName, String key, long value) {
        if (assertParams(tableName, key)) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(key, value).apply();
        }
    }

    public static void setSharedPreferences(String tableName, String key, String value) {
        if (assertParams(tableName, key)) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(key, value).apply();
        }
    }

    public static void removeSharedPreferencesKey(String tableName, String key) {
        if (assertParams(tableName, key)) {
            return;
        }
        final SharedPreferences sharedPreferences = getSharedPreferences(tableName);
        if (sharedPreferences != null && sharedPreferences.contains(key)) {
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            if (editor != null) {
                editor.remove(key).apply();
            }
        }
    }

    private static boolean assertParams(String tableName, String key) {
        return TextUtils.isEmpty(tableName) || TextUtils.isEmpty(key);
    }
}

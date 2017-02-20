package com.zhc.appdesignlibrary;

import java.io.Serializable;

/**
 * Created by qqq on 2017/2/20.
 */

public class GlobalVariables implements Serializable, Cloneable {
    private static final long serialVersionUID = 1l;
    private static final String TAG = "GlobalVariables";
    private static GlobalVariables instance;

    public static UserBean user;

    private GlobalVariables() {

    }

    public static GlobalVariables getInstance() {
        if (instance == null) {
            Object object = Utils.restoreObject(AppConstants.CACHE_DIR + TAG);
            if (object == null) {
                object = new GlobalVariables();
                Utils.saveObject(AppConstants.CACHE_DIR + TAG, object);
            }
            instance = (GlobalVariables) object;
            return instance;
        } else {
            return instance;
        }
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        GlobalVariables.user = user;
        Utils.saveObject(AppConstants.CACHE_DIR + TAG, this);
    }


}

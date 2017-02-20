package com.zhc.appdesignlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by qqq on 2017/2/20.
 */

public class Utils {

    public static final void saveObject(String path, Object object) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = new File(path);

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static final Object restoreObject(String path) {
        FileInputStream fis = null;
        ObjectInputStream oos = null;
        Object object = null;
        File f = new File(path);

        if (!f.exists()) {
            return null;
        }
        try {
            fis = new FileInputStream(f);
            oos = new ObjectInputStream(fis);
            object = oos.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

}

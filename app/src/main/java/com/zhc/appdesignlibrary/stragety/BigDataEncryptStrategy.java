package com.zhc.appdesignlibrary.stragety;

import com.zhc.appdesignlibrary.stragety.avrol.io.Encoder;
import com.zhc.appdesignlibrary.stragety.avrol.io.EncoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 大数据加密方式，使用AVRO
 */
public class BigDataEncryptStrategy implements IEncryptStrategy<byte[]> {

    private Encoder mEncoder;

    @Override
    public byte[] encryptLog(LogDataEntity entity) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        mEncoder = EncoderFactory.get().directBinaryEncoder(os, null);

        writeAllDataToEncode(entity);
        try {
            mEncoder.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return os.toByteArray();
    }

    private void writeAllDataToEncode(LogDataEntity entity) {

    }
}

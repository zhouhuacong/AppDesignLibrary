/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhc.appdesignlibrary.strategy.avrol.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/** A Utf8 string.  Unlike {@link String}, instances are mutable.  This is more
 * efficient than {@link String} when reading or writing a sequence of values,
 * as a single instance may be reused. */
public class Utf8 implements Comparable<Utf8>, CharSequence {
    private static final byte[] EMPTY = new byte[0];
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private byte[] bytes = EMPTY;
    private int length;
    private String string;

    public Utf8(String string) {
        if (string != null) {
            this.bytes = getBytesFor(string);
            this.length = bytes.length;
            this.string = string;
        }
    }

    /** Return UTF-8 encoded bytes.
     * Only valid through {@link #getByteLength()}. */
    public byte[] getBytes() {
        return bytes;
    }

    /** Return length in bytes. */
    public int getByteLength() {
        return length;
    }

    private abstract static class Utf8Converter {
        public abstract String fromUtf8(byte[] bytes, int length);

        public abstract byte[] toUtf8(String str);
    }

    private static final Utf8Converter UTF8_CONVERTER =
            System.getProperty("java.version").startsWith("1.6.") ? new Utf8Converter() { // optimized for Java 6
                public String fromUtf8(byte[] bytes, int length) {
                    try {
                        return new String(bytes, 0, length, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }

                public byte[] toUtf8(String str) {
                    try {
                        return str.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
                    : new Utf8Converter() { // faster in Java 7 & 8
                public String fromUtf8(byte[] bytes, int length) {
                    return new String(bytes, 0, length, UTF8);
                }

                public byte[] toUtf8(String str) {
                    return str.getBytes(UTF8);
                }
            };

    @Override
    public String toString() {
        if (this.length == 0)
            return "";
        if (this.string == null) {
            this.string = UTF8_CONVERTER.fromUtf8(bytes, length);
        }
        return this.string;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Utf8))
            return false;
        Utf8 that = (Utf8) o;
        if (!(this.length == that.length))
            return false;
        byte[] thatBytes = that.bytes;
        for (int i = 0; i < this.length; i++)
            if (bytes[i] != thatBytes[i])
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.length; i++)
            hash = hash * 31 + bytes[i];
        return hash;
    }

    @Override
    public int compareTo(Utf8 that) {
        return 0;
    }

    // CharSequence implementation
    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    /** Gets the UTF-8 bytes for a String */
    public static final byte[] getBytesFor(String str) {
        return UTF8_CONVERTER.toUtf8(str);
    }

}

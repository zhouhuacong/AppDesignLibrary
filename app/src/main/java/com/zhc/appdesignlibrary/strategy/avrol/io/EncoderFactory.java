/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhc.appdesignlibrary.strategy.avrol.io;

import java.io.OutputStream;

/**
 * A factory for creating and configuring {@link Encoder} instances.
 * <p/>
 * Factory methods that create Encoder instances are thread-safe.
 * Multiple instances with different configurations can be cached
 * by an application.
 * 
 * @see Encoder
 * @see BinaryEncoder
 * @see DirectBinaryEncoder
 */

public class EncoderFactory {

    private static final EncoderFactory DEFAULT_FACTORY = new EncoderFactory();

    /**
     * Returns an immutable static DecoderFactory with default configuration.
     * All configuration methods throw AvroRuntimeExceptions if called.
     */
    public static EncoderFactory get() {
        return DEFAULT_FACTORY;
    }

    /**
     * Creates or reinitializes a {@link BinaryEncoder} with the OutputStream
     * provided as the destination for written data. If <i>reuse</i> is provided,
     * an attempt will be made to reconfigure <i>reuse</i> rather than construct a
     * new instance, but this is not guaranteed, a new instance may be returned.
     * <p/>
     * The {@link BinaryEncoder} implementation returned does not buffer its
     * output, calling {@link Encoder#flush()} will simply cause the wrapped
     * OutputStream to be flushed.
     * <p/>
     * {@link BinaryEncoder} instances returned by this method are not thread-safe.
     * 
     * @param out
     *          The OutputStream to initialize to. Cannot be null.
     * @param reuse
     *          The BinaryEncoder to <i>attempt</i> to reuse given the factory
     *          configuration. A BinaryEncoder implementation may not be
     *          compatible with reuse, causing a new instance to be returned. If
     *          null, a new instance is returned.
     * @return A BinaryEncoder that uses <i>out</i> as its data output. If
     *         <i>reuse</i> is null, this will be a new instance. If <i>reuse</i>
     *         is not null, then the returned instance may be a new instance or
     *         <i>reuse</i> reconfigured to use <i>out</i>.
     * @see DirectBinaryEncoder
     * @see Encoder
     */
    public BinaryEncoder directBinaryEncoder(OutputStream out, BinaryEncoder reuse) {
        if (null == reuse || !reuse.getClass().equals(DirectBinaryEncoder.class)) {
            return new DirectBinaryEncoder(out);
        } else {
            return ((DirectBinaryEncoder) reuse).configure(out);
        }
    }

}

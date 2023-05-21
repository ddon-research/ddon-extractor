package org.sehkah.doon.tools.extractor.lib.common.io;

import org.sehkah.doon.tools.extractor.lib.common.datatype.Float2f;
import org.sehkah.doon.tools.extractor.lib.common.datatype.Vector3f;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

public class BinaryFileWriter implements FileWriter {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private static final int MAX_FILE_SIZE = 5000000;
    private final ByteBuffer byteBuffer;

    public BinaryFileWriter() {
        this(MAX_FILE_SIZE);
    }

    public BinaryFileWriter(int fileSize) {
        this(ByteBuffer.allocate(MAX_FILE_SIZE));
    }

    private BinaryFileWriter(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(DEFAULT_BYTE_ORDER);
    }

    @Override
    public byte[] getBytes() {
        return byteBuffer.array();
    }

    @Override
    public void writeUnsignedByte(int value) {
        byteBuffer.put((byte) value);
    }

    @Override
    public void writeSignedByte(byte value) {
        byteBuffer.put(value);
    }

    @Override
    public void writeBoolean(boolean value) {
        byteBuffer.put(value ? (byte) 1 : (byte) 0);
    }

    @Override
    public void writeUnsignedShort(int value) {
        byteBuffer.putShort((short) value);
    }

    @Override
    public void writeSignedShort(short value) {
        byteBuffer.putShort(value);
    }

    @Override
    public void writeUnsignedInteger(long value) {
        byteBuffer.putInt((int) value);
    }

    @Override
    public void writeUnsignedInteger(long[] value) {
        for (long l : value) {
            writeUnsignedInteger(l);
        }
    }

    @Override
    public void writeSignedInteger(int value) {
        byteBuffer.putInt(value);
    }

    @Override
    public void writeUnsignedLong(BigInteger value) {
        byteBuffer.putLong(value.longValue());
    }

    @Override
    public void writeFloat(float value) {
        byteBuffer.putFloat(value);
    }

    @Override
    public void writeFloat(float[] value) {
        for (float f : value) {
            writeFloat(f);
        }
    }

    @Override
    public void writeVector3f(Vector3f value) {
        writeFloat(value.X());
        writeFloat(value.Y());
        writeFloat(value.Z());
    }

    @Override
    public void writeVector3f(Vector3f[] value) {
        for (Vector3f f : value) {
            writeVector3f(f);
        }
    }

    @Override
    public void writeFloat2f(Float2f value) {
        writeFloat(value.X());
        writeFloat(value.Y());
    }

    @Override
    public void writeString(String value, Charset charset) {
        byteBuffer.put(value.getBytes(charset));
    }

    @Override
    public void writeString(String value) {
        writeString(value, StandardCharsets.US_ASCII);
    }

    @Override
    public void writeNullTerminatedString(String value, Charset charset) {
        writeString(value, charset);
        byteBuffer.put((byte) 0);
    }

    @Override
    public void writeNullTerminatedString(String value) {
        writeNullTerminatedString(value, StandardCharsets.US_ASCII);
    }


    @Override
    public void writeMtString(String value) {
        writeMtString(value, StandardCharsets.US_ASCII);
    }

    @Override
    public void writeMtString(String value, Charset charset) {
        byteBuffer.putLong(Integer.toUnsignedLong(value.length()));
        writeNullTerminatedString(value, charset);
    }

    @Override
    public <E> void writeArray(List<E> value, Function<FileWriter, E> entityWriterFunction) {
        writeUnsignedInteger(value.size());
        for (long i = 0; i < value.size(); i++) {
            entityWriterFunction.apply(this);
        }
    }

    @Override
    public <E> void writeArray(List<E> value, IntFunction<Void> arraySizeWriterFunction, Function<FileWriter, E> entityWriterFunction) {
        arraySizeWriterFunction.apply(value.size());
        for (long i = 0; i < value.size(); i++) {
            entityWriterFunction.apply(this);
        }
    }
}

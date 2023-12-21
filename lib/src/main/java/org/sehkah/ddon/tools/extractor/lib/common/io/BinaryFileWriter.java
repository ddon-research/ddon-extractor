package org.sehkah.ddon.tools.extractor.lib.common.io;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Float2f;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class BinaryFileWriter implements FileWriter {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private final ByteBuffer byteBuffer;

    public BinaryFileWriter(int fileSize) {
        this(ByteBuffer.allocate(fileSize));
    }

    private BinaryFileWriter(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(DEFAULT_BYTE_ORDER);
    }

    @Override
    public int getPosition() {
        return byteBuffer.position();
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
        writeUnsignedInteger(value.length());
        writeNullTerminatedString(value, charset);
    }

    @Override
    public <E> void writeArray(List<E> entities, Supplier<Consumer<E>> consumeEntity) {
        writeUnsignedInteger(entities.size());
        entities.forEach(consumeEntity.get());
    }

    @Override
    public <E> void writeArray(List<E> entities, IntFunction<Void> arraySizeWriterFunction, Supplier<Consumer<E>> consumeEntity) {
        arraySizeWriterFunction.apply(entities.size());
        entities.forEach(consumeEntity.get());
    }
}

package org.sehkah.doon.tools.extractor.lib.common.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BinaryFileReader implements FileReader {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private final ByteBuffer byteBuffer;

    public BinaryFileReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(DEFAULT_BYTE_ORDER);
    }

    public static BinaryFileReader inMemoryFromFilePath(Path path) throws IOException {
        return new BinaryFileReader(ByteBuffer.wrap(Files.readAllBytes(path)));
    }

    @Override
    public int getPosition() {
        return byteBuffer.position();
    }

    @Override
    public int readUnsignedByte() {
        return Byte.toUnsignedInt(byteBuffer.get());
    }

    @Override
    public byte readSignedByte() {
        return byteBuffer.get();
    }

    @Override
    public boolean readBoolean() {
        return byteBuffer.get() != 0;
    }

    @Override
    public int readUnsignedShort() {
        return Short.toUnsignedInt(byteBuffer.getShort());
    }

    @Override
    public short readSignedShort() {
        return byteBuffer.getShort();
    }

    @Override
    public long readUnsignedInteger() {
        return Integer.toUnsignedLong(byteBuffer.getInt());
    }

    @Override
    public int readSignedInteger() {
        return byteBuffer.getInt();
    }

    @Override
    public float readFloat() {
        return byteBuffer.getFloat();
    }

    @Override
    public double readDouble() {
        return byteBuffer.getDouble();
    }

    @Override
    public String readString(int length) {
        byte[] stringBytes = new byte[length];
        byteBuffer.get(stringBytes, byteBuffer.position(), byteBuffer.position() + length);
        return StandardCharsets.US_ASCII.decode(ByteBuffer.wrap(stringBytes)).toString();
    }

    @Override
    public <E> List<E> readArray(Function<FileReader, E> entityReaderFunction) {
        long length = readUnsignedInteger();
        List<E> entities = new ArrayList<>((int) length);
        for (long i = 0; i < length; i++) {
            entities.add(entityReaderFunction.apply(this));
        }
        return entities;
    }
}

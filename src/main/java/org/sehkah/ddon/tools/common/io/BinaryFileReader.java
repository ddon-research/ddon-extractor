package org.sehkah.ddon.tools.common.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BinaryFileReader {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private final ByteBuffer byteBuffer;

    public BinaryFileReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(DEFAULT_BYTE_ORDER);
    }

    public int getPosition() {
        return byteBuffer.position();
    }

    public long readUnsignedByte() {
        return Byte.toUnsignedLong(byteBuffer.get());
    }

    public long readSignedByte() {
        return byteBuffer.get();
    }

    public long readUnsignedShort() {
        return Short.toUnsignedLong(byteBuffer.getShort());
    }

    public long readSignedShort() {
        return byteBuffer.getShort();
    }

    public long readUnsignedInteger() {
        return Integer.toUnsignedLong(byteBuffer.getInt());
    }

    public long readSignedInteger() {
        return byteBuffer.getInt();
    }

    public float readSignedFloat() {
        return byteBuffer.getFloat();
    }

    public double readSignedDouble() {
        return byteBuffer.getDouble();
    }

    public String readStringUTF8(int length) {
        byte[] stringBytes = new byte[length];
        byteBuffer.get(stringBytes, byteBuffer.position(), byteBuffer.position() + length);
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(stringBytes)).toString();
    }

    public String readString(int length) {
        byte[] stringBytes = new byte[length];
        byteBuffer.get(stringBytes, byteBuffer.position(), byteBuffer.position() + length);
        return StandardCharsets.US_ASCII.decode(ByteBuffer.wrap(stringBytes)).toString();
    }

    public <Entity> List<Entity> readArray(Function<BinaryFileReader, Entity> entityReaderFunction) {
        long length = readUnsignedInteger();
        List<Entity> entities = new ArrayList<>((int) length);
        for (long i = 0; i < length; i++) {
            entities.add(entityReaderFunction.apply(this));
        }
        return entities;
    }

    public static BinaryFileReader inMemoryFromFilePath(Path path) throws IOException {
            return new BinaryFileReader(ByteBuffer.wrap(Files.readAllBytes(path)));
    }
}

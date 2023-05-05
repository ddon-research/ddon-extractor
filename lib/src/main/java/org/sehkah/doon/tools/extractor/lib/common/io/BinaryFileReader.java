package org.sehkah.doon.tools.extractor.lib.common.io;

import org.sehkah.doon.tools.extractor.lib.common.datatype.MtVector3;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
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
    public int getLimit() {
        return byteBuffer.limit();
    }

    @Override
    public boolean hasRemaining() {
        return byteBuffer.hasRemaining();
    }

    @Override
    public int getRemainingCount() {
        return byteBuffer.remaining();
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
    public BigInteger readUnsignedLong() {
        long i = byteBuffer.getLong();
        if (i >= 0L)
            return BigInteger.valueOf(i);
        else {
            int upper = (int) (i >>> 32);
            int lower = (int) i;

            // return (upper << 32) + lower
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32).
                    add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
        }
    }

    @Override
    public long readSignedLong() {
        return byteBuffer.getLong();
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
    public MtVector3 readMtVector3() {
        return new MtVector3(readFloat(), readFloat(), readFloat());
    }

    @Override
    public String readNullTerminatedString(Charset charset) {
        int i = byteBuffer.position();
        while (byteBuffer.get(i) != 0) {
            i++;
        }
        return readString(i + 1 - byteBuffer.position(), charset).replace("\0", "");
    }

    @Override
    public String readNullTerminatedString() {
        return readNullTerminatedString(StandardCharsets.US_ASCII).replace("\0", "");
    }

    @Override
    public String readString(int length) {
        return readString(length, StandardCharsets.US_ASCII);
    }

    @Override
    public String readString(int length, Charset charset) {
        byte[] stringBytes = new byte[length];
        byteBuffer.get(stringBytes, 0, length);
        return charset.decode(ByteBuffer.wrap(stringBytes)).toString();
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

package org.sehkah.ddon.tools.extractor.lib.common.io;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

public class BinaryFileReader implements FileReader {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private final ByteBuffer byteBuffer;

    public BinaryFileReader(Path filePath) throws IOException {
        this(Files.readAllBytes(filePath));
    }

    public BinaryFileReader(byte[] data) {
        this(ByteBuffer.wrap(data));
    }

    public BinaryFileReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.byteBuffer.order(DEFAULT_BYTE_ORDER);
    }

    @Override
    public int getPosition() {
        return byteBuffer.position();
    }

    @Override
    public void setPosition(int position) {
        byteBuffer.position(position);
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
    public byte[] readSignedByte(int num) {
        byte[] bytes = new byte[num];
        byteBuffer.get(bytes);
        return bytes;
    }

    /**
     * @return a copy of the signed bytes starting from the given offset without consuming them.
     */
    @Override
    public byte[] copySignedByte(int num, int offset) {
        return Arrays.copyOfRange(byteBuffer.array(), offset, offset + num);
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
    public long[] readUnsignedInteger(int num) {
        long[] longs = new long[num];
        for (int i = 0; i < num; i++) {
            longs[i] = readUnsignedInteger();
        }
        return longs;
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
    public float readFloat() {
        return byteBuffer.getFloat();
    }

    @Override
    public float[] readFloat(int num) {
        float[] floats = new float[num];
        for (int i = 0; i < num; i++) {
            floats[i] = readFloat();
        }
        return floats;
    }

    @Override
    public Sphere readSphere() {
        return new Sphere(
                readVector3f(),
                readFloat()
        );
    }

    @Override
    public Vector3f readVector3f() {
        return new Vector3f(readFloat(), readFloat(), readFloat());
    }

    @Override
    public Vector3f[] readVector3f(int num) {
        Vector3f[] vector3fs = new Vector3f[num];
        for (int i = 0; i < num; i++) {
            vector3fs[i] = readVector3f();
        }
        return vector3fs;
    }

    @Override
    public Vector4f readVector4f() {
        return new Vector4f(readFloat(), readFloat(), readFloat(), readFloat());
    }

    @Override
    public Vector4f[] readVector4f(int num) {
        Vector4f[] vector4fs = new Vector4f[num];
        for (int i = 0; i < num; i++) {
            vector4fs[i] = readVector4f();
        }
        return vector4fs;
    }

    @Override
    public Matrix readMatrix() {
        return new Matrix(readVector4f(), readVector4f(), readVector4f(), readVector4f());
    }

    @Override
    public Float2f readFloat2f() {
        return new Float2f(readFloat(), readFloat());
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
    public String readMtString() {
        return readMtString(StandardCharsets.US_ASCII);
    }

    @Override
    public String readMtString(Charset charset) {
        long length = Integer.toUnsignedLong(byteBuffer.getInt());
        String mtString = readString((int) length, charset);
        byteBuffer.get();
        return mtString;
    }

    @Override
    public Color readColor() {
        long rgba = readUnsignedInteger();

        int r = (int) (rgba & 0xff);
        int g = (int) ((rgba >> 8) & 0xff);
        int b = (int) ((rgba >> 16) & 0xff);
        int a = (int) ((rgba >> 24) & 0xff);

        return new Color(r, g, b, a);
    }

    @Override
    public <E> List<E> readArray(Function<FileReader, E> entityReaderFunction) {
        return readArray(FileReader::readUnsignedInteger, entityReaderFunction);
    }

    @Override
    public <E> List<E> readFixedLengthArray(long length, Function<FileReader, E> entityReaderFunction) {
        return readArray(length, entityReaderFunction);
    }

    @Override
    public <E> List<E> readArray(ToLongFunction<FileReader> arraySizeFunction, Function<FileReader, E> entityReaderFunction) {
        long length = arraySizeFunction.applyAsLong(this);
        return readArray(length, entityReaderFunction);
    }

    @Override
    public <E> List<E> readArray(long length, Function<FileReader, E> entityReaderFunction) {
        List<E> entities = new ArrayList<>((int) length);
        for (long i = 0; i < length; i++) {
            entities.add(entityReaderFunction.apply(this));
        }
        return entities;
    }
}

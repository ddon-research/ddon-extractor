package org.sehkah.ddon.tools.extractor.lib.common.io;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.*;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

public interface FileReader {
    int getPosition();

    void setPosition(int position);

    int getLimit();

    boolean hasRemaining();

    int getRemainingCount();

    int readUnsignedByte();

    byte readSignedByte();

    byte[] readSignedByte(int num);

    byte[] copySignedByte(int num, int offset);

    boolean readBoolean();

    int readUnsignedShort();

    short readSignedShort();

    long readUnsignedInteger();

    long[] readUnsignedInteger(int num);

    int readSignedInteger();

    BigInteger readUnsignedLong();

    float readFloat();

    float[] readFloat(int num);

    Sphere readSphere();

    Vector3f readVector3f();

    Vector3f[] readVector3f(int num);

    Vector4f readVector4f();

    Vector4f[] readVector4f(int num);

    Matrix readMatrix();

    Float2f readFloat2f();

    String readNullTerminatedString(Charset charset);

    String readNullTerminatedString();

    String readString(int length);

    String readString(int length, Charset charset);

    String readMtString();

    String readMtString(Charset charset);

    Color readColor();

    <E> List<E> readArray(Function<FileReader, E> entityReaderFunction);

    <E> List<E> readFixedLengthArray(long length, Function<FileReader, E> entityReaderFunction);

    <E> List<E> readArray(ToLongFunction<FileReader> arraySizeFunction, Function<FileReader, E> entityReaderFunction);

    <E> List<E> readArray(long length, Function<FileReader, E> entityReaderFunction);
}

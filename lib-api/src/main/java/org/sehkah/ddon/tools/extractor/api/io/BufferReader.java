package org.sehkah.ddon.tools.extractor.api.io;

import org.sehkah.ddon.tools.extractor.api.datatype.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToLongFunction;

public interface BufferReader {
    int getPosition();

    void setPosition(int position);

    ByteOrder getByteOrder();

    void setByteOrder(ByteOrder byteOrder);

    ByteOrder getDefaultByteOrder();

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

    Cylinder readCylinder();

    Rectangle readRectangle();

    Vector2f readVector2f();

    Vector3f readVector3f();

    Vector3f[] readVector3f(int num);

    Vector4f readVector4f();

    Vector4f[] readVector4f(int num);

    Matrix readMatrix();

    Float2f readFloat2f();

    String readNullTerminatedString(Charset charset);

    String readNullTerminatedString();

    String readJapaneseNullTerminatedString();

    String readString(int length);

    String readString(int length, Charset charset);

    String readMtString();

    String readMtString(Charset charset);

    Color readColor();

    Color4l readColor4l();

    OrientedBoundingBox readOrientedBoundingBox();

    AxisAlignedBoundingBox readAxisAlignedBoundingBox();

    <E> List<E> readArray(Function<BufferReader, E> entityReaderFunction);

    <E> List<E> readArray(BiFunction<BufferReader, ResourceMetadataLookupUtil, E> entityReaderFunction, ResourceMetadataLookupUtil entityMetadataLookupUtil);

    <E> List<E> readFixedLengthArray(long length, Function<BufferReader, E> entityReaderFunction);

    <E> List<E> readArray(ToLongFunction<BufferReader> arraySizeFunction, Function<BufferReader, E> entityReaderFunction);

    <E> List<E> readArray(ToLongFunction<BufferReader> arraySizeFunction, BiFunction<BufferReader, ResourceMetadataLookupUtil, E> entityReaderFunction, ResourceMetadataLookupUtil entityMetadataLookupUtil);

    <E> List<E> readArray(long length, Function<BufferReader, E> entityReaderFunction);

    <E> List<E> readArray(long length, BiFunction<BufferReader, ResourceMetadataLookupUtil, E> entityReaderFunction, ResourceMetadataLookupUtil entityMetadataLookupUtil);
}

package org.sehkah.doon.tools.extractor.lib.common.io;

import java.util.List;
import java.util.function.Function;

public interface FileReader {
    int getPosition();

    long readUnsignedByte();

    long readSignedByte();

    boolean readBoolean();

    long readUnsignedShort();

    long readSignedShort();

    long readUnsignedInteger();

    long readSignedInteger();

    float readSignedFloat();

    double readSignedDouble();

    String readStringUTF8(int length);

    String readString(int length);

    <Entity> List<Entity> readArray(Function<FileReader, Entity> entityReaderFunction);
}

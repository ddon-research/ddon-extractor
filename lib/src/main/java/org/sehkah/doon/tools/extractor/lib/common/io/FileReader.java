package org.sehkah.doon.tools.extractor.lib.common.io;

import java.util.List;
import java.util.function.Function;

public interface FileReader {
    int getPosition();

    int getLimit();

    boolean hasRemaining();

    int getRemainingCount();

    int readUnsignedByte();

    byte readSignedByte();

    boolean readBoolean();

    int readUnsignedShort();

    short readSignedShort();

    long readUnsignedInteger();

    int readSignedInteger();

    float readFloat();

    double readDouble();

    String readString(int length);

    <Entity> List<Entity> readArray(Function<FileReader, Entity> entityReaderFunction);
}

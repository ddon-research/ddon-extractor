package org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferWriter;

public class FileHeaderSerializer {
    private static void writeVersion(BufferWriter bufferWriter, long versionNumber, int versionBytesLength) {
        if (versionBytesLength == 4) {
            bufferWriter.writeUnsignedInteger(versionNumber);
        } else if (versionBytesLength == 2) {
            bufferWriter.writeUnsignedShort((int) versionNumber);
        }
    }

    private static void writeMagicString(BufferWriter bufferWriter, String magicString) {
        bufferWriter.writeString(magicString);
    }

    protected void serializeClientResourceFile(FileHeader fileHeader, BufferWriter bufferWriter) {
        if (fileHeader.magicBytesLength() > 0) {
            writeMagicString(bufferWriter, fileHeader.magicString());
        }
        if (fileHeader.versionBytesLength() > 0) {
            writeVersion(bufferWriter, fileHeader.versionNumber(), fileHeader.versionBytesLength());
        }
    }
}

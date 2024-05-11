package org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;

public class FileHeaderSerializer {
    private static void writeVersion(FileWriter fileWriter, long versionNumber, int versionBytesLength) {
        if (versionBytesLength == 4) {
            fileWriter.writeUnsignedInteger(versionNumber);
        } else if (versionBytesLength == 2) {
            fileWriter.writeUnsignedShort((int) versionNumber);
        }
    }

    private static void writeMagicString(FileWriter fileWriter, String magicString) {
        fileWriter.writeString(magicString);
    }

    protected void serializeClientResourceFile(FileHeader fileHeader, FileWriter fileWriter) {
        if (fileHeader.magicBytesLength() > 0) {
            writeMagicString(fileWriter, fileHeader.magicString());
        }
        if (fileHeader.versionBytesLength() > 0) {
            writeVersion(fileWriter, fileHeader.versionNumber(), fileHeader.versionBytesLength());
        }
    }
}

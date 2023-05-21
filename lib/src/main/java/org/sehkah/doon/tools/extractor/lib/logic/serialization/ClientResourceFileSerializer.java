package org.sehkah.doon.tools.extractor.lib.logic.serialization;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileWriter;
import org.sehkah.doon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileSerializer implements Serializer<TopLevelClientResource> {
    protected final ClientResourceFile clientResourceFile;

    protected ClientResourceFileSerializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public byte[] serializeResource(TopLevelClientResource clientResource) {
        // TODO: retrieve the expected file size from the original serialization
        FileWriter fileWriter = new BinaryFileWriter();
        if (clientResourceFile.fileHeader.magicBytesLength > 0) {
            fileWriter.writeString(clientResourceFile.fileHeader.magicString);
        }
        if (clientResourceFile.fileHeader.versionBytesLength == 4) {
            fileWriter.writeUnsignedInteger(clientResourceFile.fileHeader.versionNumber);
        } else if (clientResourceFile.fileHeader.versionBytesLength == 2) {
            fileWriter.writeUnsignedShort((int) clientResourceFile.fileHeader.versionNumber);
        }
        serializeClientResourceFile(clientResource, fileWriter);
        return fileWriter.getBytes();
    }

    protected abstract void serializeClientResourceFile(TopLevelClientResource clientResource, FileWriter fileWriter);
}

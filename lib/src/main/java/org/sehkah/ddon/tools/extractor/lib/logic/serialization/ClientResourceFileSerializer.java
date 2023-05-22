package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import lombok.Getter;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileWriter;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileSerializer implements Serializer<TopLevelClientResource> {
    @Getter
    private final ClientResourceFile clientResourceFile;

    protected ClientResourceFileSerializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public TopLevelClientResource deserialize(String serialized, Class<TopLevelClientResource> cls) {
        return null;
    }

    @Override
    public byte[] serializeResource(TopLevelClientResource clientResource) {
        FileWriter fileWriter = new BinaryFileWriter(clientResource.getFileSize());
        if (clientResourceFile.getFileHeader().getMagicBytesLength() > 0) {
//            fileWriter.writeUnsignedInteger(FileHeader.magicNumber(clientResourceFile.getFileHeader().getMagicString()));
            fileWriter.writeString(clientResourceFile.getFileHeader().getMagicString());
        }
        if (clientResourceFile.getFileHeader().getVersionBytesLength() == 4) {
            fileWriter.writeUnsignedInteger(clientResourceFile.getFileHeader().getVersionNumber());
        } else if (clientResourceFile.getFileHeader().getVersionBytesLength() == 2) {
            fileWriter.writeUnsignedShort((int) clientResourceFile.getFileHeader().getVersionNumber());
        }
        serializeClientResourceFile(clientResource, fileWriter);
        return fileWriter.getBytes();
    }

    protected abstract void serializeClientResourceFile(TopLevelClientResource clientResource, FileWriter fileWriter);
}

package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import lombok.Getter;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileWriter;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;

public abstract class ClientResourceFileSerializer<T extends TopLevelClientResource> implements ClientResourceSerializer<T> {
    @Getter
    private final ClientResourceFile clientResourceFile;

    protected ClientResourceFileSerializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public byte[] serializeResource(T clientResource) {
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
        if (fileWriter.getPosition() != clientResource.getFileSize()) {
            throw new TechnicalException("The written bytes '%s' do not match up with the original size '%s'!".formatted(fileWriter.getBytes().length, clientResource.getFileSize()));
        }
        return fileWriter.getBytes();
    }

    protected abstract void serializeClientResourceFile(T clientResource, FileWriter fileWriter);
}

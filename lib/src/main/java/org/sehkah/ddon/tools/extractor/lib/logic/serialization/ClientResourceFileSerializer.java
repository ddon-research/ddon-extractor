package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileWriter;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.FileHeader;

@Slf4j
public abstract class ClientResourceFileSerializer<T extends TopLevelClientResource> implements ClientResourceSerializer<T> {
    @Getter
    private final ClientResourceFile clientResourceFile;
    private boolean isModdingAllowed = false;

    protected ClientResourceFileSerializer(ClientResourceFile clientResourceFile) {
        this.clientResourceFile = clientResourceFile;
    }

    @Override
    public byte[] serializeResource(T clientResource) {
        FileWriter fileWriter = new BinaryFileWriter(clientResource.getFileSize());
        FileHeader fileHeader = getClientResourceFile().getFileHeader();
        if (fileHeader.getMagicBytesLength() > 0) {
            fileWriter.writeString(fileHeader.getMagicString());
        }
        if (fileHeader.getVersionBytesLength() == 4) {
            fileWriter.writeUnsignedInteger(fileHeader.getVersionNumber());
        } else if (fileHeader.getVersionBytesLength() == 2) {
            fileWriter.writeUnsignedShort((int) fileHeader.getVersionNumber());
        }
        serializeClientResourceFile(clientResource, fileWriter);
        if (fileWriter.getPosition() != clientResource.getFileSize()) {
            if (isModdingAllowed()) {
                log.warn("The written bytes '{}' do not match up with the original size '{}'!", fileWriter.getPosition(), clientResource.getFileSize());
            } else {
                throw new TechnicalException("The written bytes '%s' do not match up with the original size '%s'!".formatted(fileWriter.getPosition(), clientResource.getFileSize()));
            }
        }
        return fileWriter.getBytes();
    }

    @Override
    public boolean isModdingAllowed() {
        return isModdingAllowed;
    }

    @Override
    public void setModdingAllowed(boolean isModdingAllowed) {
        this.isModdingAllowed = isModdingAllowed;
    }

    protected abstract void serializeClientResourceFile(T clientResource, FileWriter fileWriter);
}

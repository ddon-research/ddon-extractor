package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryFileWriter;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileWriter;

@Slf4j
public abstract class ClientResourceFileSerializer<T extends TopLevelClientResource> implements ClientResourceSerializer<T> {
    private static final FileHeaderSerializer fileHeaderSerializer = new FileHeaderSerializer();
    private boolean isModdingAllowed = false;

    protected ClientResourceFileSerializer() {
    }

    @Override
    public byte[] serializeResource(T clientResource) {
        FileWriter fileWriter = new BinaryFileWriter(clientResource.getFileSize());
        fileHeaderSerializer.serializeClientResourceFile(clientResource.getFileHeader(), fileWriter);
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

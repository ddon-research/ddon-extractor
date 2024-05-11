package org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BinaryWriter;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferWriter;

@Slf4j
public abstract class ClientResourceFileSerializer<T extends TopLevelClientResource> implements ClientResourceSerializer<T> {
    private static final FileHeaderSerializer fileHeaderSerializer = new FileHeaderSerializer();
    private boolean isModdingAllowed = false;

    protected ClientResourceFileSerializer() {
    }

    @Override
    public byte[] serializeResource(T clientResource) {
        BufferWriter bufferWriter = new BinaryWriter(clientResource.getFileSize());
        fileHeaderSerializer.serializeClientResourceFile(clientResource.getFileHeader(), bufferWriter);
        serializeClientResourceFile(clientResource, bufferWriter);
        if (bufferWriter.getPosition() != clientResource.getFileSize()) {
            if (isModdingAllowed()) {
                log.warn("The written bytes '{}' do not match up with the original size '{}'!", bufferWriter.getPosition(), clientResource.getFileSize());
            } else {
                throw new TechnicalException("The written bytes '%s' do not match up with the original size '%s'!".formatted(bufferWriter.getPosition(), clientResource.getFileSize()));
            }
        }
        return bufferWriter.getBytes();
    }

    @Override
    public boolean isModdingAllowed() {
        return isModdingAllowed;
    }

    @Override
    public void setModdingAllowed(boolean isModdingAllowed) {
        this.isModdingAllowed = isModdingAllowed;
    }

    protected abstract void serializeClientResourceFile(T clientResource, BufferWriter bufferWriter);
}

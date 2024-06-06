package org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryWriter;
import org.sehkah.ddon.tools.extractor.api.io.BufferWriter;

@Slf4j
public abstract class ClientResourceFileSerializer<T extends TopLevelClientResource> implements ClientResourceSerializer<T> {
    private static final FileHeaderSerializer fileHeaderSerializer = new FileHeaderSerializer();

    protected ClientResourceFileSerializer() {
    }

    @Override
    public byte[] serializeResource(T clientResource) {
        BufferWriter bufferWriter = new BinaryWriter(clientResource.getFileSize());
        fileHeaderSerializer.serializeClientResourceFile(clientResource.getFileHeader(), bufferWriter);
        serializeClientResourceFile(clientResource, bufferWriter);
        if (bufferWriter.getPosition() != clientResource.getFileSize()) {
            throw new TechnicalException("The written bytes '%s' do not match up with the expected size '%s'!".formatted(bufferWriter.getPosition(), clientResource.getFileSize()));
        }
        return bufferWriter.getBytes();
    }

    protected abstract void serializeClientResourceFile(T clientResource, BufferWriter bufferWriter);
}

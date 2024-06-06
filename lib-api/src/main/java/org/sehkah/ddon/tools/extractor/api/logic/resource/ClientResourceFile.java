package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.api.logic.resource.serialization.ClientResourceSerializer;

@Data
public class ClientResourceFile<T extends TopLevelClientResource> {
    private ClientResourceFileExtension fileExtension;
    //TODO: Get rid of fileheader here, should be part of top level resource file instead
    private FileHeader fileHeader;
    private Pair<ClientResourceFileExtension, FileHeader> identifier;
    private ClientResourceDeserializer<T> deserializer;
    private ClientResourceSerializer<T> serializer;

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader) {
        this(fileExtension, fileHeader, null, null);
    }

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader, ClientResourceDeserializer<T> deserializer) {
        this(fileExtension, fileHeader, deserializer, null);
    }

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader, ClientResourceDeserializer<T> deserializer, ClientResourceSerializer<T> serializer) {
        this.fileExtension = fileExtension;
        this.fileHeader = fileHeader;
        this.identifier = Pair.of(fileExtension, fileHeader);
        this.deserializer = deserializer;
        this.serializer = serializer;
    }
}

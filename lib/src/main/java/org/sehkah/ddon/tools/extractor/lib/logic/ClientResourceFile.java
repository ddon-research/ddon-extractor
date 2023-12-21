package org.sehkah.ddon.tools.extractor.lib.logic;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;
import org.sehkah.ddon.tools.extractor.lib.common.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.serialization.ClientResourceSerializer;

import java.lang.reflect.InvocationTargetException;

@Data
public class ClientResourceFile {
    private ClientResourceFileExtension fileExtension;
    private FileHeader fileHeader;
    private Pair<ClientResourceFileExtension, FileHeader> identifier;
    private ClientResourceDeserializer<TopLevelClientResource> deserializer;
    private ClientResourceSerializer<TopLevelClientResource> serializer;

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader) {
        this(fileExtension, fileHeader, null, null);
    }

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader, Class<?> deserializerClass) {
        this(fileExtension, fileHeader, deserializerClass, null);
    }

    public ClientResourceFile(ClientResourceFileExtension fileExtension, FileHeader fileHeader, Class<?> deserializerClass, Class<?> serializerClass) {
        try {
            this.fileExtension = fileExtension;
            this.fileHeader = fileHeader;
            this.identifier = Pair.of(fileExtension, fileHeader);
            if (deserializerClass != null) {
                this.deserializer = (ClientResourceDeserializer<TopLevelClientResource>) deserializerClass.getConstructor(ClientResourceFile.class).newInstance(this);
            }
            if (serializerClass != null) {
                this.serializer = (ClientResourceSerializer<TopLevelClientResource>) serializerClass.getConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new TechnicalException(e);
        }
    }
}

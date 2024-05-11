package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.fieldarea.MarkerInfo;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaMarkerInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MarkerInfo readMarkerInfo(FileReader fileReader) {
        return new MarkerInfo(
                fileReader.readVector3f(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(FileReader fileReader) {
        return new FieldAreaMarkerInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo)
        );
    }
}

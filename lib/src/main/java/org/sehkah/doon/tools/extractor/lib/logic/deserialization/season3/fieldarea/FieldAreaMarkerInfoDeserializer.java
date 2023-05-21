package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.fieldarea.MarkerInfo;

public class FieldAreaMarkerInfoDeserializer extends ClientResourceFileDeserializer<FieldAreaMarkerInfo> {
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

    private static FieldAreaMarkerInfo readEntity(FileReader fileReader) {
        return new FieldAreaMarkerInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FieldAreaMarkerInfoDeserializer::readMarkerInfo)
        );
    }

    @Override
    protected FieldAreaMarkerInfo parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}

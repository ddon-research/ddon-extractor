package org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.FieldAreaMarkerInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.MarkerInfo;

public class FieldAreaMarkerInfoDeserializer extends FileDeserializer {
    public FieldAreaMarkerInfoDeserializer() {
        super(ClientResourceFile.rFieldAreaMarkerInfo);
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
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}

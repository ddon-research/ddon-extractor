package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.FieldMapData;

import java.util.List;

public class FieldMapDataDeserializer extends ClientResourceFileDeserializer<List<FieldMapData>> {
    public FieldMapDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FieldMapData readEntity(FileReader fileReader) {
        return new FieldMapData(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFloat2f(),
                fileReader.readVector3f(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<FieldMapData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FieldMapDataDeserializer::readEntity);
    }
}

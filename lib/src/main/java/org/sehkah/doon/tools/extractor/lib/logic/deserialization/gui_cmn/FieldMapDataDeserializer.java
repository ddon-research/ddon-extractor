package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.FieldMapData;

import java.util.List;

public class FieldMapDataDeserializer extends FileDeserializer<List<FieldMapData>> {
    public FieldMapDataDeserializer() {
        super(ClientResourceFile.rFieldMapData);
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
    protected List<FieldMapData> readObject(FileReader fileReader) {
        return fileReader.readArray(FieldMapDataDeserializer::readEntity);
    }
}

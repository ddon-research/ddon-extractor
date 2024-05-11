package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.FieldMapData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.FieldMapDataList;

public class FieldMapDataDeserializer extends ClientResourceFileDeserializer {
    public FieldMapDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FieldMapData readFieldMapData(FileReader fileReader) {
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
    protected FieldMapDataList parseClientResourceFile(FileReader fileReader) {
        return new FieldMapDataList(fileReader.readArray(FieldMapDataDeserializer::readFieldMapData));
    }
}

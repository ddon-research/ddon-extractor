package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.FieldMapData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.FieldMapDataList;

public class FieldMapDataDeserializer extends ClientResourceFileDeserializer {
    public FieldMapDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FieldMapData readFieldMapData(BufferReader bufferReader) {
        return new FieldMapData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readFloat2f(),
                bufferReader.readVector3f(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldMapDataList parseClientResourceFile(BufferReader bufferReader) {
        return new FieldMapDataList(bufferReader.readArray(FieldMapDataDeserializer::readFieldMapData));
    }
}

package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn.AbilityData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.gui_cmn.AbilityDataList;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer {
    public AbilityDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AbilityData readAbilityData(BufferReader bufferReader) {
        return new AbilityData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected AbilityDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AbilityDataList(bufferReader.readArray(AbilityDataDeserializer::readAbilityData));
    }
}

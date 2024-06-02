package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CycleContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.CycleContentsSortieInfoTable;

public class CycleContentsSortieInfoDeserializer extends ClientResourceFileDeserializer {
    public CycleContentsSortieInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CycleContentsSortieInfoData readCycleContentsSortieInfoData(BufferReader bufferReader) {
        return new CycleContentsSortieInfoData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected CycleContentsSortieInfoTable parseClientResourceFile(BufferReader bufferReader) {
        return new CycleContentsSortieInfoTable(bufferReader.readArray(CycleContentsSortieInfoDeserializer::readCycleContentsSortieInfoData));
    }
}

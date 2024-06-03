package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoTable;

public class EndContentsSortieInfoDeserializer extends ClientResourceFileDeserializer {
    public EndContentsSortieInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EndContentsSortieInfoData readEndContentsSortieInfoData(BufferReader bufferReader) {
        return new EndContentsSortieInfoData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EndContentsSortieInfoTable parseClientResourceFile(BufferReader bufferReader) {
        return new EndContentsSortieInfoTable(bufferReader.readArray(EndContentsSortieInfoDeserializer::readEndContentsSortieInfoData));
    }
}

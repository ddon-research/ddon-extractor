package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EndContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.EndContentsSortieInfoTable;

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
